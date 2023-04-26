package com.example.zyy.Service;

import com.example.zyy.zyyModel.pojo.Article;

import java.io.IOException;
import java.util.Map;

public interface EsService {
    Map<String,Object> getArticle(String key, String index, int start, int r) throws IOException;
}
