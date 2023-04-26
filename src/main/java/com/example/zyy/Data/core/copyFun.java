package com.example.zyy.Data.core;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class copyFun {
    public static void main(String[] args) {
//        try (
//                BufferedReader reader = new BufferedReader(new FileReader("D:\\IdeaProject\\SpringBootTry_ELK\\src\\main\\resources\\threeThou.json"));
//                BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\IdeaProject\\SpringBootTry_ELK\\src\\main\\resources\\newThreeThou.json"));
//        ) {
            try (
                    BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\IdeaProject\\SpringBootTry_ELK\\src\\main\\resources\\newThreeThou.json", true));
            ) {
//                writer.write("{\"data\": [");
//                writer.newLine();
//
//                String line;
//                int count = 290000; // 文件中的行数
//
//                for (int i = 0; i < 600; i++) {
////                    if(i!=0) reader.reset(); // 每次循环前重置输入流，以便重新读取文件
//                    BufferedReader reader = new BufferedReader(new FileReader("D:\\IdeaProject\\SpringBootTry_ELK\\src\\main\\resources\\threeThou.json"));
//
//                    while ((line = reader.readLine()) != null) {
//                        writer.write(line);
//                        writer.newLine();
//                        count++;
//                    }
//
//                    // 每一百万行数据就清理一次缓存区
//                    if (count % 1000000 == 0) {
//                        writer.flush();
//                    }
//                }

                // 最后关闭文件流并强制刷出所有数据
//                writer.close();

                writer.write("]}");
                writer.newLine();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }