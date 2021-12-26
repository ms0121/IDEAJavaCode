package com.liu.springmvc.controller;

import com.liu.springmvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @author lms
 * @date 2021-09-25 - 21:26
 * <p>
 * 非法请求拦截的模拟实现
 * login：登录不拦截(不需要登录即可访问)
 * add：  未登录就拦截（访问前需要登录）
 * update：未登录就拦截（访问前需要登录）
 */

@Controller
@RequestMapping("userInfo")
public class LoginController {

    @RequestMapping("login")
    public ModelAndView login(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        user.setId(1);
        user.setName("admin");
        user.setAge(20);
        // 将当前登录用户的信息设置在session中
        session.setAttribute("user", user);
        modelAndView.setViewName("success");
        return modelAndView;
    }


    @RequestMapping("add")
    public ModelAndView add() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("update")
    public ModelAndView update() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");
        return modelAndView;
    }

}
