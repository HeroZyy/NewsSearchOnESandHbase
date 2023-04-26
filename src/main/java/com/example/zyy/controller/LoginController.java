package com.example.zyy.controller;

import com.example.zyy.Service.LoginService;
import com.example.zyy.resp.CommonResp;
import com.example.zyy.zyyModel.pojo.user;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@RestController
@CrossOrigin
public class LoginController {
    @Resource
    LoginService loginService;
    @GetMapping("/login")
    public String login(@RequestParam(name = "account", defaultValue = "admin") String account,@RequestParam(name = "passwd", defaultValue = "123456") String passwd) throws NoSuchAlgorithmException, JsonProcessingException {
        HashMap<String, String> m = loginService.login(account, passwd);
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(m));
        return objectMapper.writeValueAsString(m);
    }

    @PostMapping("/list")
    public CommonResp login(){
        CommonResp<List<user>> resp = new CommonResp<>();
        LinkedList<user> list = loginService.list();
        resp.setContent(list);
        return resp;
    }

    @PostMapping("/findByB")
    public CommonResp findLike(String account){
        CommonResp<List<user>> resp = new CommonResp<>();
        LinkedList<user> list = loginService.findByB(account);
        resp.setContent(list);
        return resp;
    }
}
