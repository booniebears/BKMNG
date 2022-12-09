package com.csy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    private String admin_id;
    private String admin_name;
    private String admin_sex;
    private Date admin_birth;
    private String admin_password;
}
