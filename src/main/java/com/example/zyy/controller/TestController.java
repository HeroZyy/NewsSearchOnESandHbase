package com.example.zyy.controller;


import com.example.zyy.Service.ServieImpl.myTestImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
public class TestController {
    @Value("${test.hello}")
    private String testHello;
    @Autowired
    myTestImpl TestImpl;
    @GetMapping("/test")
    @ResponseBody
    String searchTest(String id) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(TestImpl.SearchTest(id));
    }
    @GetMapping("/hello")
    String hello(){
        return "hello world!"+testHello;
    }
    @PostMapping("/hello/post")
    String helloPost(String name){
        return "hello world!"+name;
    }
}
