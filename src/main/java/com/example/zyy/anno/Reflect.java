package com.example.zyy.anno;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflect {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        //获取Person的类对象
        Class<?> annotationClass = Class.forName("com.example.zyy.anno.Person");

        //获取Person的实例
        Constructor<?> constructor = annotationClass.getConstructor(String.class, int.class);
        Object per = constructor.newInstance("zyy", 22);

        //调用Person类的方法
        Method speak = annotationClass.getDeclaredMethod("Speak");
        speak.invoke(per);

        //访问Person类的字段
        Field id = annotationClass.getDeclaredField("id");
        id.setAccessible(true);
        Integer na = (Integer) id.get(per);
        System.out.println("id = " + na);
    }
}
