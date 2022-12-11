package com.csy.dao;

import com.csy.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BookMapper {
    int addBook(Books books); //增加一本书

    //@Param注解
    int deleteBookById(@Param("book_id") String id); //根据id,删除一本书

    int updateBook(Books books); //更新一本书

    Books queryBookById(@Param("book_id") String id); //根据id,查询一本书

    List<Books> queryAllBooks(); //查询所有书

    Books queryBooksByName(@Param("name") String name); //根据名字查询图书

    void borrowBook(Map<String, Object> hashMap); //借书过程
}
