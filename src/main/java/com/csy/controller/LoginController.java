package com.csy.controller;

import com.csy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    //登录
    @Autowired
    @Qualifier("AdminServiceImpl")
    private AdminService adminService;

    @RequestMapping("/login")
    public String login(Model model, HttpSession session, String username,
                        String password, String isAdmin) {
        //可能是因为提交的问题,所以username和password可能为null;因此这里要判断一下
        if (username != null && password != null) {
            System.out.println("isAdmin = " + isAdmin);
            System.out.println("username = " + username);
            System.out.println("password = " + password);
            if (isAdmin != null && adminService.login(username, password)) {
                session.setAttribute("UserLoginInfo", username);
                return "redirect:/book/allBook";
            } else {
                model.addAttribute("login_error", "用户名或密码错误");
            }
        }

        return "redirect:/";
    }
}
