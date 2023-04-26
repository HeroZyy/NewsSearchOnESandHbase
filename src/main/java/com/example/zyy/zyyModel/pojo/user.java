package com.example.zyy.zyyModel.pojo;

public class user {
    String account;
    String passwd;

    public user() {
    }

    @Override
    public String toString() {
        return "user{" +
                "account='" + account + '\'' +
                ", passwd='" + passwd + '\'' +
                '}';
    }

    public user(String account, String passwd) {
        this.account = account;
        this.passwd = passwd;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
