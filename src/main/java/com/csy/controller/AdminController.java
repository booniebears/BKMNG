package com.csy.controller;

import com.csy.pojo.BorrowInfo;
import com.csy.pojo.Student;
import com.csy.service.AdminService;
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
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    @Qualifier("AdminServiceImpl")
    private AdminService adminService;

    @RequestMapping("/allStudent")
    public String queryAllStudents(Model model, HttpServletRequest req) {
        List<Student> list = adminService.queryAllStudents();
        model.addAttribute("stu_list", list);
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("UserLoginInfo");
        if (username != null) {
            model.addAttribute("UserLoginInfo", username);
        }
        return "allStudent";
    }

    @RequestMapping("/addStudentPage")
    public String addStudentPage(HttpServletRequest req, Model model) {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("UserLoginInfo");
        if (username != null) {
            model.addAttribute("UserLoginInfo", username);
        }
        return "addStudent";
    }

    @RequestMapping("/addStudent")
    public String addStudent(Student student, HttpServletRequest req) {
        adminService.addStudent(student);
        return "redirect:/admin/allStudent";
    }

    @RequestMapping("/updateStuPage")
    public String updateStuPage(String id, Model model, HttpServletRequest req) {
        Student student = adminService.queryStudentById(id);
        model.addAttribute("QueryStudent", student);
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("UserLoginInfo");
        if (username != null) {
            model.addAttribute("UserLoginInfo", username);
        }
        return "updateStudent";
    }

    @RequestMapping("/updateStu")
    public String updateStu(Student student) {
        adminService.updateStudent(student);
        return "redirect:/admin/allStudent";
    }

    @RequestMapping("/deleteStu/{stu_id}")
    public String deleteStu(@PathVariable("stu_id") String id) {
        adminService.deleteStudentById(id);
        return "redirect:/admin/allStudent";
    }

    @RequestMapping("/queryStu")
    public String queryStu(String queryStuName, Model model) {
        Student student = adminService.queryStudentByName(queryStuName);
        List<Student> list = new ArrayList<>();
        list.add(student);
        if (student == null && queryStuName != null) {
            list = adminService.queryAllStudents();
            model.addAttribute("error", "未找到学生");
        }
        model.addAttribute("stu_list", list);
        return "allStudent";
    }

    //管理员可以查看迄今为止所有的图书借阅信息
    @RequestMapping("/borrowInfo")
    public String queryAllBorrowInfo(Model model, HttpServletRequest req) {
        List<BorrowInfo> list = adminService.queryAllBorrowInfo();
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
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("UserLoginInfo");
        if (username != null) {
            model.addAttribute("UserLoginInfo", username);
        }
        return "borrowInfo";
    }


}
