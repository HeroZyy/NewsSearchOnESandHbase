package com.example.zyy.Service;

import com.example.zyy.zyyModel.pojo.user;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.LinkedList;

public interface LoginService {
    HashMap<String,String> login(String account, String passwd) throws NoSuchAlgorithmException;

    LinkedList<user> list();

    LinkedList<user> findByB(String account);
}
