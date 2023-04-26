package com.example.zyy;

public class Book {
    private Author author;
    Book(){}
    Book(Author author){
        this.author = author;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
