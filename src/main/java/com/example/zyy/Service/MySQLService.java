package com.example.zyy.Service;
import com.example.zyy.MySQLTest.pojo.Article;

import java.util.Map;

public interface MySQLService {
    Map<String,Object> search(String id , String title , String describe , String content) throws InterruptedException;
}
