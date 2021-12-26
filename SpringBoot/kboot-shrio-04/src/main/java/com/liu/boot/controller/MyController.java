package com.liu.boot.controller;

import com.liu.boot.pojo.User;
import com.liu.boot.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author lms
 * @date 2021-05-14 - 11:28
 */
@Controller
public class MyController {

    @Autowired
    private UserService userService;


    @GetMapping({"/", "index"})
    public String index(Model model){
        model.addAttribute("msg", "hello， shrio!");
        return "index";
    }


    @GetMapping("/user/add")
    public String add(Model model){
        model.addAttribute("msg", "hello， add!");
        return "user/add";
    }

    @GetMapping("/user/update")
    public String update(Model model){
        model.addAttribute("msg", "hello， update!");
        return "user/update";
    }

    @GetMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @GetMapping("/user_db")
    @ResponseBody
    public User getUser(){
        System.out.println("==========================");
        User user = userService.selectUserByName("Lisa");
        return user;
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String username, String password, Model model) {
        // 获取当前的用户信息
        Subject subject = SecurityUtils.getSubject();
        // 封装当前的登录数据信息
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 使用token进行登录
        try {
            // 登陆成功，跳转到首页
            subject.login(token);
            return "index";
        }catch (UnknownAccountException e){
            // 用户名不存在
            model.addAttribute("msg","用户名不存在");
            return "login";
        }catch (IncorrectCredentialsException e){
            // 密码不正确
            model.addAttribute("msg","密码错误");
            return "login";
        }
    }

    @GetMapping("/unau")
    public String unauth(Model model){
        model.addAttribute("msg","你没有被授权，当前页面无法访问！");
        return "user/unauth";
    }
}









