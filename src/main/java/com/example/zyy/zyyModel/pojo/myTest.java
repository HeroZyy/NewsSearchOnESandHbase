package com.example.zyy.zyyModel.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * article
 * @author 
 */
@Data
public class myTest implements Serializable {
    private String id;

    private String title;

    private String describe;

    private String content;

    private String author;

    private String time;

    private static final long serialVersionUID = 1L;
}