package com.example.zyy.controller;

import com.example.zyy.Service.ServieImpl.EsServiceImpl;
import com.example.zyy.zyyModel.pojo.Article;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

@RestController
@CrossOrigin
public class ESController {
    @Autowired
    EsServiceImpl esServiceImpl;
    @GetMapping("/article")
    @ResponseBody
    public String getEsArticle(@RequestParam(name = "key", defaultValue = "") String key,
                                           @RequestParam(name = "index", defaultValue = "article") String index,
                                           @RequestParam(name = "start", defaultValue = "0") int start,
                                           @RequestParam(name = "row", defaultValue = "1000") int row
                                           ) throws IOException {
        Map<String, Object> map = esServiceImpl.getArticle(key, index, start, row);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(map);
    }

}
