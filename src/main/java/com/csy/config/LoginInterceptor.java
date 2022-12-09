package com.csy.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断哪些情况下登录了,就放行
        //首先获取Session
        HttpSession session = request.getSession();
        if (request.getRequestURI().contains("login")) {
            return true;
        }
        if (session.getAttribute("UserLoginInfo") != null) {
            System.out.println("成功登录!!!");
            return true;
        }
        System.out.println("登录失败!!!");
        //其他情况下，自行转发到首页去
        request.getRequestDispatcher("/index.jsp").forward(request, response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
