//package com.example.zyy.Data.core;
//
//import com.imooc.utils.EsUtil;
//import com.imooc.utils.HBaseUtil;
//import com.imooc.utils.RedisUtil;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import redis.clients.jedis.Jedis;
//
//import java.util.List;
//import java.util.Map;
//
///**
// * 在ES中对HBase中的数据建立索引
// *
// */
//
//public class DataIndex {
//    private final static Logger logger = LoggerFactory.getLogger(DataIndex.class);
//    public static void main(String[] args) {
//        List<String> rowKeyList = null;
//        Jedis jedis = null;
//        try {
//            //1：首先从Redis的列表中获取Rowkey
//            jedis = RedisUtil.getJedis();
//            //brpop如果获取到了数据，返回的list里面有两列，第一列是key的名称，第二列是具体的数据
//            rowKeyList = jedis.brpop(3, "l_article_ids");
////            System.out.println(rowKeyList);
//            while (rowKeyList != null) {
//                String rowKey = rowKeyList.get(1);
//
//                //2：根据Rowkey到HBase中获取数据的详细信息
//                Map<String, String> map = HBaseUtil.getFromHBase("article", rowKey);
//                System.out.println(map);
//                //3：在ES中对数据建立索引
//                EsUtil.addIndex("article",rowKey,map);
//                //循环从Redis的列表中获取Rowkey
//                rowKeyList = jedis.brpop(3, "l_article_ids");
//            }
//        }
//        catch (Exception e){
//            logger.error("数据建立索引失败："+e.getMessage());
//            //在这里可以考虑把获取出来的rowKey再push到Redis中，这样可以保证数据不丢
//            if(rowKeyList!=null){
//                jedis.rpush("l_article_ids",rowKeyList.get(1));
//            }
//        }finally {
//            //向连接池返回连接
//            if(jedis!=null){
//                RedisUtil.returnResource(jedis);
//            }
//            //注意：确认ES连接不再使用了再关闭连接，否则会导致client无法继续使用
//            try{
//                EsUtil.closeRestClient();
//            }catch (Exception e){
//                logger.error("ES连接关闭失败："+e.getMessage());
//            }
//        }
//    }
//}
