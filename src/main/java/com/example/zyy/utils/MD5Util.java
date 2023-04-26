package com.example.zyy.utils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

    public static String md5(String password) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(password.getBytes());
        byte[] resultBytes = messageDigest.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : resultBytes) {
            int num = b & 0xff;
            String str = Integer.toHexString(num);
            if (str.length() == 1) {
                sb.append("0");
            }
            sb.append(str);
        }
        return sb.toString();
    }
}