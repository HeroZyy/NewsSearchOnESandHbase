package com.example.zyy.zyyModel.dao;

import com.example.zyy.MySQLTest.pojo.Article;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ArticleDao {
    int deleteByPrimaryKey(String id);

    int insert(Article record);

    int insertSelective(Article record);

    List<Article> selectByPrimaryKey(String id);

    List<Article> selectByTitle(String title);

    List<Article> selectByContent(String content);

    List<Article> selectByDescribe(String describe);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);


}