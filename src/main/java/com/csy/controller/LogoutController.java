package com.csy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LogoutController {
    //移除Session中的UserLoginInfo,回到登录页。这就完成了Logout操作
    @RequestMapping("/logout")
    public String logout(HttpServletRequest req){
        req.getSession().removeAttribute("UserLoginInfo");
        return "redirect:/";
    }
}
