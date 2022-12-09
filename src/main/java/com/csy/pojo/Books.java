package com.csy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books {
    private String book_id;
    private String book_name;
    private String book_author;
    private String book_publisher;
    private double book_price;
    private int book_number;
}
