package com.csy.service;

import com.csy.dao.BookMapper;
import com.csy.pojo.Books;

import java.util.List;
import java.util.Map;


public class BookServiceImpl implements BookService {
    //业务层调用DAO层
    private BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public int addBook(Books books) {
        return bookMapper.addBook(books);
    }

    @Override
    public int deleteBookById(String id) {
        return bookMapper.deleteBookById(id);
    }

    @Override
    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    @Override
    public Books queryBookById(String id) {
        return bookMapper.queryBookById(id);
    }

    @Override
    public List<Books> queryAllBooks() {
        return bookMapper.queryAllBooks();
    }

    @Override
    public Books queryBooksByName(String name) {
        return bookMapper.queryBooksByName(name);
    }

    @Override
    public void borrowBook(Map<String, Object> hashMap) {
        bookMapper.borrowBook(hashMap);
    }

    @Override
    public void returnBook(Map<String, Object> hashMap) {
        bookMapper.returnBook(hashMap);
    }

    @Override
    public void renewBook(Map<String, Object> hashMap) {
        bookMapper.renewBook(hashMap);
    }
}
