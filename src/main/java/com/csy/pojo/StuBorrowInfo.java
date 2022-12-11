package com.csy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StuBorrowInfo {
    private int borrow_id;
    private String name;
    private String book_name;
    private String borrow_time;
    private String return_time;
    private String renew_time;
}
