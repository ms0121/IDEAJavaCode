package com.liu.boot.controller;

import com.liu.boot.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

/**
 * @author lms
 * @date 2021-05-10 - 13:32
 */

@Controller
public class LoginController {

    // value表示当前的多个请求，都执行同一个方法
    @GetMapping(value = {"/", "/login", "/login.html"})
    public String login() {
        return "login";
    }

    // 提交post请求的登录，跳转到登陆成功的页面
    // 表示当前的请求来自login页面，提交方法是post请求的方法
    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model) {
        if (StringUtils.hasLength(user.getUserName()) && "123456".equals(user.getPassword())) {
            // 把登录成功的用户保存起来
            session.setAttribute("loginUser", user);
            // 登陆成功之后，重定向到main.html；重定向可以防止表单的重复提交
            return "redirect:/main.html";
        } else {
            model.addAttribute("msg", "账号密码错误，请重新登录!");
            // 回到登录页面
            return "login";
        }
    }

    @GetMapping("/main.html")
    public String mainPage(HttpSession session, Model model) {
        User user = (User) session.getAttribute("loginUser");
        System.out.println("user = " + user);
        if (user != null) {
            // 跳转到主页面
            return "main";
        } else {
            model.addAttribute("msg", "请重新登录！");
            // 如果没有登录则跳转到首页
            return "login";
        }
    }

}
