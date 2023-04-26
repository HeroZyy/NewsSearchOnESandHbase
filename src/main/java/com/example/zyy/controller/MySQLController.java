package com.example.zyy.controller;

import com.example.zyy.MySQLTest.pojo.Article;
import com.example.zyy.Service.MySQLService;
import com.example.zyy.Service.ServieImpl.MySQLServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@CrossOrigin
public class MySQLController {
    @Autowired
    MySQLService mySQLService;
    @GetMapping("/mysql")
    @ResponseBody
    public String search(String id, String title , String describe, String content) throws JsonProcessingException, InterruptedException {
        //搜索时，id表示所有字段关键字，通过id赋值给t，d，content三个字段来进行查找
        Map<String,Object> map = mySQLService.search(id, title, describe, content);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(map);
    }
}
