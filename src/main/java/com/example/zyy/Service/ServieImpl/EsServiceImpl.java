package com.example.zyy.Service.ServieImpl;


import com.example.zyy.Service.EsService;
import com.example.zyy.utils.EsUtil;
import com.example.zyy.zyyModel.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
public class EsServiceImpl implements EsService {

    @Override
    public Map<String, Object> getArticle(String key, String index, int start, int row) throws IOException {
        //根据搜索的数据，索引库名称，，开始位置，条数在ElasticSearch中搜索索引
        Map<String, Object> map = EsUtil.search(key, index, start, row);
        return map;
    }
}
