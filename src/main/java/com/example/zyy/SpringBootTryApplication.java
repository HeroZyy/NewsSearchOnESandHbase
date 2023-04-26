package com.example.zyy;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan(basePackages = "com.example.zyy.zyyModel.dao")
@MapperScan(basePackages = {"com.example.zyy.zyyModel.dao"})
public class SpringBootTryApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootTryApplication.class, args);
    }
}
