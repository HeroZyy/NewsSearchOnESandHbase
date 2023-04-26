package com.example.zyy.Data.core;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class checkData {
    public static void main(String[] args) {
//        try (
//                BufferedReader reader = new BufferedReader(new FileReader("D:\\IdeaProject\\SpringBootTry_ELK\\src\\main\\resources\\threeThou.json"));
//                BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\IdeaProject\\SpringBootTry_ELK\\src\\main\\resources\\newThreeThou.json"));
//        ) {
        try (
                BufferedReader reader2 = new BufferedReader(new FileReader("D:\\IdeaProject\\SpringBootTry_ELK\\src\\main\\resources\\threeThou.json"));
        ) {
            BufferedReader reader = new BufferedReader(new FileReader("D:\\IdeaProject\\SpringBootTry_ELK\\src\\main\\resources\\output.json"));

            String line;
            HashMap<String , Integer > m = new HashMap<>();
            m.put("书画",0);
            m.put("法治",0);
            m.put("社会",0);
            m.put("国内",0);
            m.put("人物",0);
            m.put("国际",0);
            m.put("文娱",0);
            m.put("教育",0);
            m.put("生活",0);
            m.put("健康",0);
            m.put("三农",0);
            m.put("军事",0);
            m.put("经济",0);
            while ((line = reader.readLine()) != null) {
                if (line.contains("\"author\": ")) {
                    if(!m.containsKey(line)) m.put(line,1);
                    else {
                        int num = m.get(line);
                        m.put(line,num+1);
                    }
                }
            }
            Iterator<Map.Entry<String, Integer>> entryIterator = m.entrySet().iterator();
            while (entryIterator.hasNext()){
                Map.Entry<String, Integer> entry = entryIterator.next();
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
