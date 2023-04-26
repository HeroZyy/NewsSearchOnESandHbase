package com.example.zyy.zyyModel.dao;

import com.example.zyy.zyyModel.pojo.user;
import org.apache.ibatis.annotations.*;

import java.util.LinkedList;

public interface LoginDao {
    @Select("SELECT account, passwd FROM user WHERE account = #{account}")
    @Results({
            @Result(property = "account", column = "account"),
            @Result(property = "passwd", column = "passwd"),
    })
    user findByAcc(@Param("account") String account);

    @Select("SELECT passwd FROM user WHERE account = #{account}")
    String findPasswd(String account);

    @Select("SELECT account FROM user WHERE account = #{account}")
    String findByA(String account);

    @Select("select * from user")
    LinkedList<user> list();

    @Select("select * from user where account like '%${account}%'")
    LinkedList<user> findByB(String account);


}
