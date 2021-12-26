package com.liu.boot.controller;

import com.liu.boot.bean.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author lms
 * @date 2021-05-21 - 15:33
 */

@RestController
@RequestMapping("/user")  // 共同的访问路径
public class UserController {

    // 用户登录请求
    @GetMapping("/login")
    public String getLogin(HttpSession session){
        User user = new User();
        user.setId(1);
        user.setName("zhangsan");
        session.setAttribute("user", user);
        return "login";
    }

    // 等于登陆之后才能访问到当前的这个页面
    @GetMapping("/center")
    public String getCenter(){
        return "welcome to user's center";
    }

    // 未登录直接跳转到当前页面
    @GetMapping("/error")
    public String getError(){
        return "error";
    }
}
