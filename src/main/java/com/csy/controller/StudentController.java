package com.csy.controller;

import com.csy.pojo.Books;
import com.csy.pojo.BorrowInfo;
import com.csy.service.AdminService;
import com.csy.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    @Qualifier("AdminServiceImpl")
    private AdminService adminService;

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
        return "StuAllBook";
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
        return "StuAllBook";
    }

    //学生可以查看迄今为止自己的图书借阅信息
    @RequestMapping("/borrowInfo")
    public String queryStudentBorrowInfo(Model model, HttpServletRequest req) throws ParseException {

        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("UserLoginInfo");
        if (username != null) {
            model.addAttribute("UserLoginInfo", username);
        }
        /*
        * queryStudentBorrowInfo得到的数据结构不应该是BorrowInfo，
        * 似乎需要重新定义。恐怕需要在pojo中新增一项了
        * */
        List<BorrowInfo> list = adminService.queryStudentBorrowInfo(username);
        //一处补丁。如果将生日日期定义为String类型,似乎从SQL的Datetime转换过来之后，会多一个".0"在末尾。
        //故这里字符串处理一下
        for (BorrowInfo borrowInfo : list) {
            String[] split = null;
            String borrow_time = borrowInfo.getBorrow_time();
            if (borrow_time != null) {
                split = borrow_time.split("\\.");
                borrowInfo.setBorrow_time(split[0]);
            }
            String return_time = borrowInfo.getReturn_time();
            if (return_time != null) {
                split = return_time.split("\\.");
                borrowInfo.setReturn_time(split[0]);
            }
            String renew_time = borrowInfo.getRenew_time();
            if (renew_time != null) {
                split = renew_time.split("\\.");
                borrowInfo.setRenew_time(split[0]);
            }
        }
        model.addAttribute("Info_list", list);
        return "StuBorrowInfo";
    }

}
