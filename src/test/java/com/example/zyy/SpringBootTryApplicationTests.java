package com.example.zyy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.support.TaskUtils;

@SpringBootTest
class SpringBootTryApplicationTests {
    @Autowired
    Author author;
    @Autowired
    Book book;
    @Autowired
    MyConfig myConfig;
    @Test
    void contextLoads() {
        System.out.println("author = " + author);
        System.out.println("myConfig = " + myConfig);
        System.out.println("(author == book.getAuthor()) = " + (author == book.getAuthor()));
    }
}
