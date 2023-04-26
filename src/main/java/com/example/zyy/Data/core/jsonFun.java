package com.example.zyy.Data.core;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import org.json.*;
public class jsonFun {
//    D:\IdeaProject\SpringBootTry_ELK\src\main\resources\newThreeThou.json
public static void main(String[] args) {
    BufferedReader reader = null;
    BufferedWriter writer = null;

    try {
        reader = new BufferedReader(new FileReader("D:\\IdeaProject\\SpringBootTry_ELK\\src\\main\\resources\\newThreeThou.json"));
        writer = new BufferedWriter(new FileWriter("D:\\IdeaProject\\SpringBootTry_ELK\\src\\main\\resources\\output.json"));

        String currentLine;
        int count = 1;

        while ((currentLine = reader.readLine()) != null) {
            // 判断当前行是否包含"id"字符串，如果包含，则替换掉原有的"id"以及其后面的字符串
            if (currentLine.contains("\"id\": ")) {
                int indexStart = currentLine.indexOf("\"id\": ") + "\"id\": ".length();
//                int indexEnd = currentLine.substring(indexStart).indexOf("\"") + indexStart;
//                String originalId = currentLine.substring(indexStart, indexEnd);
//                System.out.println(currentLine.substring(0, indexStart));
                String newId = "" + count; // TODO: 在这里添加您要替换成的新字符串
                currentLine = currentLine.substring(0, indexStart) + newId ;
//                        + currentLine.substring(indexEnd);
                count++;
            }

            // 将修改后的当前行写入到输出文件中。
            writer.write(currentLine);
            writer.newLine(); // 每行输出时加上一个换行符
        }
        writer.flush(); // 把缓存中的数据刷到硬盘中
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            if (reader != null) {
                reader.close();
            }

            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
}