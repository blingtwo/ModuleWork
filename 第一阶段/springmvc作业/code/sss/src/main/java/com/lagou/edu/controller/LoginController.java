package com.lagou.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("/handler")
    public String login(HttpSession session, String username, String password){
        if (username == null || password == null) { return "login";}

        if (username.equals("admin") && password.equals("admin")) {
            //登录成功
            System.out.println("登录成功！");
            session.setAttribute("LOGIN_USER",username);
            return "redirect:/resume/queryResumes";
        } else {
            //登录失败
            System.out.println("登录失败！");
            return "login";
        }
    }
    @RequestMapping("/logoutHandler")
    public String loginOut(HttpSession httpSession) {
        httpSession.invalidate();
        return "login";
    }
}
