package com.example.zyy.controller;

import com.example.zyy.Service.ServieImpl.HBaseServiceImpl;
import com.example.zyy.utils.HBaseUtil;
import com.example.zyy.zyyModel.pojo.Article;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
@CrossOrigin
public class HBaseController {
    @Autowired
    HBaseServiceImpl hBaseServiceImpl;
    @GetMapping("/detailArticleById")
    @ResponseBody
    public String getHBase (@RequestParam(name = "id")  String id) throws IOException {
        Map<String, String> fromHBase = hBaseServiceImpl.getFromHBase("article", id);
        Map<String, String> map = HBaseUtil.getFromHBase("article", id);
        Article article = new Article();
        article.setId(id);
        article.setTitle(map.get("title"));
        article.setAuthor(map.get("author"));
        article.setDescribe(map.get("describe"));
        article.setContent(map.get("content"));
        article.setTime(map.get("time"));
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(article);
        return json;
    }
}
