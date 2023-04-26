package com.example.zyy.MySQLTest.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * article
 * @author 
 */
@Data
public class Article implements Serializable {
    public String id;

    public String title;

    public String describe;

    public String content;

    public String author;

    public String time;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", describe='" + describe + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}