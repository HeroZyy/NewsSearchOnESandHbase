package com.example.zyy.anno;

import java.lang.annotation.*;
import java.lang.reflect.Method;


public class annotation {
    @Test(value = "example")
    public void testMethod() {
        System.out.println("Test method executed");
    }
    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException {
        annotation anno = new annotation();
        Method t = anno.getClass().getMethod("testMethod");
        Test annotation = t.getAnnotation(Test.class);
        System.out.println(annotation.value());
    }
}
