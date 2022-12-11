package com.csy.controller;

import com.csy.pojo.Books;
import com.csy.pojo.StuBorrowInfo;
import com.csy.pojo.Student;
import com.csy.service.AdminService;
import com.csy.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
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
        List<StuBorrowInfo> list = adminService.queryStudentBorrowInfo(username);

        list = MyDateFormatter(list); //对每一项日期部分作格式化
        model.addAttribute("Info_list", list);
        return "StuBorrowInfo";
    }

    @RequestMapping("/borrowBook/{bk_id}")
    public String borrowBook(@PathVariable("bk_id") String book_id, HttpServletRequest req,
                             Model model) {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("UserLoginInfo");
        Student student = adminService.queryStudentByName(username);
        //给借书过程传参,这里使用Map将所有in/out参数打包传入.out部分可以先赋值为Null
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("stu_id", student.getId());
        hashMap.put("bk_id", book_id);
        hashMap.put("message", null);

        bookService.borrowBook(hashMap);

        //调用完毕之后,看一下hashMap的out参数状况
        Integer message = (Integer) hashMap.get("message");
        //如果库存不足
        if (message == -1) {
            model.addAttribute("borrowError", "库存不足!");
            List<Books> list = bookService.queryAllBooks();
            model.addAttribute("list", list);
            return "StuAllBook";
        }
        //之前考虑了图书不存在的情况,不过目前看来,如果结合前端设计,可能并不是很有必要。下面就是借阅成功,跳转到BorrowInfo
        return "redirect:/student/borrowInfo";
    }

    @RequestMapping("/returnBook/{borrow_id}")
    public String returnBook(@PathVariable("borrow_id") String borrowID,
                             Model model,HttpServletRequest req) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("borrowID", borrowID);
        hashMap.put("message", null);

        bookService.returnBook(hashMap);

        Integer message = (Integer) hashMap.get("message");
        //这里专门处理不能重复归还的情况。设计存储过程的时候还考虑了没有此书借阅记录的情况，在这里应该不用考虑
        if(message == -1){
            model.addAttribute("returnError","已经归还!");
            HttpSession session = req.getSession();
            String username = (String) session.getAttribute("UserLoginInfo");

            List<StuBorrowInfo> list = adminService.queryStudentBorrowInfo(username);
            list = MyDateFormatter(list); //对每一项日期部分作格式化

            model.addAttribute("Info_list", list);
            return "StuBorrowInfo";
        }
        return "redirect:/student/borrowInfo";
    }

    @RequestMapping("/renewBook/{borrow_id}")
    public String renewBook(@PathVariable("borrow_id") String borrowID,
                            Model model,HttpServletRequest req){
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("borrowID", borrowID);
        hashMap.put("message", null);

        bookService.renewBook(hashMap);

        Integer message = (Integer) hashMap.get("message");
        if(message == -1){
            model.addAttribute("returnError","已经归还!");
            HttpSession session = req.getSession();
            String username = (String) session.getAttribute("UserLoginInfo");

            List<StuBorrowInfo> list = adminService.queryStudentBorrowInfo(username);
            list = MyDateFormatter(list); //对每一项日期部分作格式化

            model.addAttribute("Info_list", list);
            return "StuBorrowInfo";
        }
        return "redirect:/student/borrowInfo";
    }

    public List<StuBorrowInfo> MyDateFormatter(List<StuBorrowInfo> list){
        //一处补丁。如果将生日日期定义为String类型,似乎从SQL的Datetime转换过来之后，会多一个".0"在末尾。
        //故这里字符串处理一下
        for (StuBorrowInfo borrowInfo : list) {
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
        return list;
    }
}
