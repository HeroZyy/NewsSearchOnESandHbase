package com.example.zyy.Data.core;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class checkData {
    public static void main(String[] args) {
//        try (
//                BufferedReader reader = new BufferedReader(new FileReader("D:\\IdeaProject\\SpringBootTry_ELK\\src\\main\\resources\\threeThou.json"));
//                BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\IdeaProject\\SpringBootTry_ELK\\src\\main\\resources\\newThreeThou.json"));
//        ) {
//        try (
//                BufferedReader reader2 = new BufferedReader(new FileReader("D:\\IdeaProject\\SpringBootTry_ELK\\src\\main\\resources\\threeThou.json"));
//        )
//        {
//            BufferedReader reader = new BufferedReader(new FileReader("D:\\IdeaProject\\SpringBootTry_ELK\\src\\main\\resources\\threeThou.json"));

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
            double sum =
            2176             +
            776             +
            4000             +
            4000             +
            576             +
            800             +
            4000             +
            4000             +
            1336             +
            4160             +
            800             +
            1144             +
            2320             +
            4800             +
            1048             ;

            ArrayList<Double> d = new ArrayList<>();
            ArrayList<Double> res = new ArrayList<>();
            Double num1 = 2176.0 ;
            Double num2 = 776.0  ;
            Double num3 = 4000.0 ;
            Double num4 = 4000.0 ;
            Double num5 = 576.0  ;
            Double num6 = 800.0  ;
            Double num7 = 4000.0 ;
            Double num8 = 4000.0 ;
            Double num9 = 1336.0 ;
            Double num0 = 4160.0 ;
            Double num11= 800.0  ;
            Double num12= 1144.0 ;
            Double num13= 2320.0 ;
            Double num14= 4800.0 ;
            Double num15= 1048.0 ;
            res.add(num1 );
            res.add(num2 );
            res.add(num3 );
            res.add(num4 );
            res.add(num5 );
            res.add(num6 );
            res.add(num7 );
            res.add(num8 );
            res.add(num9 );
            res.add(num0 );
            res.add(num11);
            res.add(num12);
            res.add(num13);
            res.add(num14);
            res.add(num15);
            for (Double re : res) {
                d.add(re/sum);
            }
            for (Double re : d) {
                System.out.println(re*100);
            }

//
//            while ((line = reader.readLine()) != null) {
//                if (line.contains("\"author\": ")) {
//                    if(!m.containsKey(line)) m.put(line,1);
//                    else {
//                        int num = m.get(line);
//                        m.put(line,num+1);
//                    }
//                }
//            }
//            Iterator<Map.Entry<String, Integer>> entryIterator = m.entrySet().iterator();
//            while (entryIterator.hasNext()){
//                Map.Entry<String, Integer> entry = entryIterator.next();
//                System.out.println(entry.getKey() + ":" + entry.getValue());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}
