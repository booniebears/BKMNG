package com.csy.service;

import com.csy.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {
    int addBook(Books books); //增加一本书

    //@Param注解
    int deleteBookById(String id); //根据id,删除一本书

    int updateBook(Books books); //更新一本书

    Books queryBookById(String id); //根据ID查询一本书

    List<Books> queryAllBooks(); //查询所有书

    Books queryBooksByName(String name); //根据名字查询图书

}
