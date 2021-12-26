package com.liu.dubbo.web;

import com.liu.dubbo.model.User;
import com.liu.dubbo.service.SomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lms
 * @date 2021-05-23 - 15:35
 */

@Controller
public class SomeController {

    @Autowired
    private SomeService someService;

    @RequestMapping("/hello")
    public String hello(Model model){
        String hello = someService.hello();
        model.addAttribute("hello", hello);
        return "hello";
    }

    @RequestMapping("/user/userDetail")
    public String userDetail(Model model, Integer id){
        User user = someService.queryUserById(id);
        model.addAttribute("user", user);
        return "userDetail";
    }



}
