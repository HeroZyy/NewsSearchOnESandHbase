package com.example.zyy.anno;

public class Person {
    String name ; int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void Speak(){
        System.out.println("this.name = " + this.name);
    }
}
