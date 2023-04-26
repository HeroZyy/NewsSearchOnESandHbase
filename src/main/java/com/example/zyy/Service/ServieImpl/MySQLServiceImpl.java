package com.example.zyy.Service.ServieImpl;

import com.example.zyy.MySQLTest.pojo.Article;
import com.example.zyy.Service.MySQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.zyy.zyyModel.dao.ArticleDao;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class MySQLServiceImpl implements  MySQLService{
    @Autowired
    ArticleDao articleDao;
    @Override
    public Map<String, Object> search(String id, String title , String describe, String content) throws InterruptedException {
        HashMap<String ,Object> map = new HashMap<>();
        Article article = null;
        //对三个字段进行模糊查询，如果查找到代表article不为null
        title = id ;
        describe = id;
        content = id;
        LinkedList<Article> list = new LinkedList<>();
        List<Article> articles = articleDao.selectByTitle(title);
        if (articles != null)  {
            list.addAll(articles);
        }
        List<Article> articles1 = articleDao.selectByContent(content);
        if (articles1 != null)  {
            for (Article article1 : articles1) {
                if(list.contains(article1)) continue;
                list.add(article1);
            }
        }
        List<Article> articles2 = articleDao.selectByContent(describe);
        if (articles2 != null)  {
            for (Article article1 : articles2) {
                if(list.contains(article1)) continue;
                list.add(article1);
            }
        }
        map.put("dataList",list);

        Thread.sleep(500);
        return map;
    }
}