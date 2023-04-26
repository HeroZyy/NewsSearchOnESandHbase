package com.example.zyy.controller;

import com.example.zyy.Service.ZyyService;
import com.example.zyy.zyyModel.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
/*

 */
public class ZyyServiceController {
    @Autowired
    ZyyService zyyService;
    @GetMapping("/bb")
    @ResponseBody
    public String getStudent(){
        return zyyService.getStudent().toString();
    }
}
