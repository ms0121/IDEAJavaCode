package com.liu.jwt.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lms
 * @date 2021-10-01 - 22:05
 *
 * 方式1：将用户信息设置在session中保存
 */
@RestController
@RequestMapping("test")
public class SessionController {

    @PostMapping("login")
    public String login(String userName, String password, HttpServletRequest request){
        // 将用户名和密码拼接后设置在session作用域中
        request.getSession().setAttribute("user", userName + password);
        return "Login Success！";
    }
}
