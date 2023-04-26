package com.example.zyy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    @Bean
    Author author(){
        return new Author();
    }

    @Bean
    Book book(){
        return new Book(author());
    }
}
