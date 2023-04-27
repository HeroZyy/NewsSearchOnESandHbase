package com.example.zyy.Service.ServieImpl;

import com.example.zyy.Service.LoginService;
import com.example.zyy.utils.MD5Util;
import com.example.zyy.zyyModel.dao.LoginDao;
import com.example.zyy.zyyModel.pojo.user;
import org.jcodings.util.Hash;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    LoginDao loginDao;
    @Override
    public HashMap<String,String> login(String account,String passwd) throws NoSuchAlgorithmException {
//        System.out.println(account);
//        System.out.println(passwd);
        System.out.println(account + ':' + passwd);
        String res = MD5Util.md5(passwd);
//        System.out.println("loginDao.findByA(account) = " + loginDao.findByA(account));
        System.out.println(account);
        System.out.println(MD5Util.md5(passwd));
        HashMap<String,String> status = new HashMap<>();
        if(res.equals(loginDao.findPasswd(account) ))  {
            status.put("connect","1");
        }
        else {
            status.put("connect","0");
        }
        return status;
    }

    @Override
    public Integer updatePasswd(String account, String passwd, String newpasswd) throws NoSuchAlgorithmException {
        newpasswd = MD5Util.md5(newpasswd);
        passwd = MD5Util.md5(passwd);
        return  loginDao.updatePasswd(account,passwd,newpasswd);
    }

    @Override
    public LinkedList<user> list() {
        return loginDao.list();
    }

    @Override
    public LinkedList<user> findByB(String account) {
        return loginDao.findByB(account);
    }

}
