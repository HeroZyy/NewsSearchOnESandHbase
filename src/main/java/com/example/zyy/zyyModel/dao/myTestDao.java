package com.example.zyy.zyyModel.dao;

import com.example.zyy.zyyModel.pojo.myTest;
import org.springframework.stereotype.Repository;

@Repository
public interface myTestDao {
    int deleteByPrimaryKey(String id);

    int insert(myTest record);

    int insertSelective(myTest record);

    myTest selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(myTest record);

    int updateByPrimaryKey(myTest record);
}