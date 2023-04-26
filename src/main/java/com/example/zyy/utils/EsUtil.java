package com.example.zyy.utils;

import com.example.zyy.zyyModel.pojo.Article;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHost;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.apache.http.impl.nio.reactor.IOReactorConfig;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * ES工具类
 */

public class EsUtil {
    private EsUtil() {
    }

    private static RestHighLevelClient client;

    static {
        //获取RestClient连接
        //注意：高级别客户端其实是对低级别客户端的代码进行了封装，所以连接池使用的是低级别客户端中的连接池
        client = new RestHighLevelClient(
                //这里的代码其实就是低级别客户端的代码
                RestClient.builder(
                        new HttpHost("hadoop000", 9200, "http"))
                        .setHttpClientConfigCallback(new RestClientBuilder.HttpClientConfigCallback()
                                                     {
                            @Override
                            public HttpAsyncClientBuilder customizeHttpClient(
                                    HttpAsyncClientBuilder httpClientBuilder) {
                                return httpClientBuilder.setDefaultIOReactorConfig(
                                        IOReactorConfig.custom()
                                                //设置线程池中线程的数量，默认是1个，建议设置为和客户端机器可用CPU数量一致
                                                .setIoThreadCount(1)
                                                .build());
                            }
                        }

                        ));
    }

    /**
     * 获取客户端
     *
     * @return
     */

    public static RestHighLevelClient getRestClient() {
        return client;
    }

    /**
     * 关闭客户端
     * 注意：调用高级别客户端的close方法时，会将低级别客户端创建的连接池整个关闭掉，最终导致client无法继续使用
     * 所以正常是用不到这个close方法的，只有在程序结束的时候才需要调用
     *
     * @throws IOException
     */

    public static void closeRestClient() throws IOException {
        client.close();
    }

    /**
     * 建立索引
     *
     * @param index
     * @param id
     * @param map
     * @throws Exception
     */

    public static void addIndex(String index, String id, Map<String, String> map) throws IOException {
        IndexRequest request = new IndexRequest(index);
        request.id(id);
        request.source(map);
        //执行
        client.index(request, RequestOptions.DEFAULT);
    }

    /**
     * 全文检索功能
     *
     * @param key
     * @param index
     * @param start
     * @param row
     * @return
     * @throws IOException
     */

    public static Map<String, Object> search(String key, String index, int start, int row) throws IOException {
        SearchRequest RequestInSearch = new SearchRequest();
        //指定索引库，支持指定一个或者多个，也支持通配符
        RequestInSearch.indices(index);

        //指定searchType
        RequestInSearch.searchType(SearchType.DFS_QUERY_THEN_FETCH);

        //组装查询条件
        SearchSourceBuilder SourceForSearch = new SearchSourceBuilder();

        //如果传递了搜索参数，则拼接查询条件
        if (StringUtils.isNotBlank(key)) {
            SourceForSearch.query(QueryBuilders.multiMatchQuery(key, "title", "describe", "content"));
        }
        //分页
        SourceForSearch.from(start);
        SourceForSearch.size(row);

        //高亮
        //设置高亮字段
        HighlightBuilder hlight = new HighlightBuilder()
                .field("title")
                .field("describe")
                .field("author")
                .field("time");//支持多个高亮字段

        //设置高亮字段的前缀和后缀内容
        hlight.preTags("*");
        hlight.postTags("*");
        SourceForSearch.highlighter(hlight);

        //指定查询条件
        RequestInSearch.source(SourceForSearch);

        //执行查询操作
        SearchResponse searchResponse = client.search(RequestInSearch, RequestOptions.DEFAULT);
        //存储返回给页面的数据
        Map<String, Object> map = new HashMap<String, Object>();
        //获取查询返回的结果
        SearchHits hits = searchResponse.getHits();
        //获取数据总量
        long numHits = hits.getTotalHits().value;
//        long numHits = 10000;
        map.put("count", numHits);
        ArrayList<Article> arrayList = new ArrayList<Article>();
        //获取具体内容
        SearchHit[] searchHits = hits.getHits();
        //迭代解析具体内容
        for (SearchHit hit : searchHits) {
            Map<String, Object> mapForSource = hit.getSourceAsMap();
            String id = hit.getId();
            String title = mapForSource.get("title").toString();
            String author = mapForSource.get("author").toString();
            String describe = mapForSource.get("describe").toString();
            String time = mapForSource.get("time").toString();

            //获取高亮字段内容
            Map<String, HighlightField> highlightFields = hit.getHighlightFields();
            //获取title字段的高亮内容
            HighlightField highlightField = highlightFields.get("title");
            if (highlightField != null) {
                Text[] fragments = highlightField.getFragments();
                title = "";
                for (Text text : fragments) {
                    title += text;
                }
            }
            //获取describe字段的高亮内容
            HighlightField highlightField2 = highlightFields.get("describe");
            if (highlightField2 != null) {
                Text[] fragments = highlightField2.fragments();
                describe = "";
                for (Text text : fragments) {
                    describe += text;
                }
            }
            //把文章信息封装到Article对象中
            Article a = new Article();
            a.setId(id);
            a.setTitle(title);
            a.setAuthor(author);
            a.setDescribe(describe);
            a.setTime(time);
            //最后再把拼装好的article添加到list对象汇总
            arrayList.add(a);
        }
        map.put("dataList", arrayList);
        return map;
    }
}
