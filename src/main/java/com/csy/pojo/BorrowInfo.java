package com.csy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowInfo {
    private int borrow_id;
    private String id;
    private String book_id;
    private String borrow_time;
    private String return_time;
    private String renew_time;
}
