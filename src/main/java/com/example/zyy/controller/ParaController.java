package com.example.zyy.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ParaController {
    @GetMapping("/aa")
    public String test(@RequestParam Integer num){
        System.out.println(num);
        return "得到了"+num;
    }
}
