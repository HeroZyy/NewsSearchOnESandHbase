package com.example.zyy.zyyModel.dao;

import com.example.zyy.zyyModel.pojo.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}