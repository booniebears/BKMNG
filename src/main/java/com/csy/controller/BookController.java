package com.csy.controller;


import com.csy.pojo.Books;
import com.csy.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    @RequestMapping("/allBook")
    public String queryAllBooks(Model model, HttpServletRequest req) {
        List<Books> list = bookService.queryAllBooks();
        model.addAttribute("list", list);
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("UserLoginInfo");
        if (username != null) {
            model.addAttribute("UserLoginInfo", username);
        }
        return "allBook";
    }

    //走到添加书籍的页面去
    @RequestMapping("/addBookPage")
    public String addBookPage(HttpServletRequest req, Model model) {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("UserLoginInfo");
        if (username != null) {
            model.addAttribute("UserLoginInfo", username);
        }
        return "addBook";
    }

    //添加书籍的具体实现
    @RequestMapping("/addBook")
    public String addBook(Books books) {
        bookService.addBook(books);
        return "redirect:/book/allBook";
    }

    //跳转到修改页面
    @RequestMapping("/updateBookPage")
    public String updateBookPage(String id, Model model, HttpServletRequest req) {
        Books books = bookService.queryBookById(id);
        model.addAttribute("QueryBooks", books);
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("UserLoginInfo");
        if (username != null) {
            model.addAttribute("UserLoginInfo", username);
        }
        return "updateBook";
    }

    //修改书籍的请求
    @RequestMapping("/updateBook")
    public String updateBook(Books books) {
        bookService.updateBook(books);
        return "redirect:/book/allBook";
    }

    //删除书籍的请求
    @RequestMapping("/deleteBook/{bk_id}")
    public String deleteBook(@PathVariable("bk_id") String id) {
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

    //查询书籍的请求
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName, Model model) {
        Books books = bookService.queryBooksByName(queryBookName);
        List<Books> list = new ArrayList<>();
        list.add(books);
        //查不到的时候,依然要返回全部书籍,只是要注明未找到
        if (books == null && queryBookName != null) {
            list = bookService.queryAllBooks();
            model.addAttribute("error", "未找到该书");
        }
        model.addAttribute("list", list);
        return "allBook";
    }

    @RequestMapping("/debugPage")
    public String debugPage() {
        return "debug";
    }
}
