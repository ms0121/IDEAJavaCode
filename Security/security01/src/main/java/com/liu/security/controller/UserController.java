package com.liu.security.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lms
 * @date 2021-10-02 - 23:45
 *
 */
@Controller
@RequestMapping("test")
public class UserController {

    @GetMapping("index")
    public String index(){
        return "index";
    }

    @GetMapping("success")
    public String success(){
        return "success";
    }


    @GetMapping("role")
    public String role(){
        return "role";
    }

    // 使用注解的方式判断当前用户是否有某个角色，没有角色的不允许访问
    @GetMapping("update")
    @ResponseBody
    @Secured({"ROLE_role"})
    public String update(){
        return "update,thanks!";
    }

    @GetMapping("hello")
    @ResponseBody
    public String hello(){
        return "hello, SpringSecurity!";
    }

}
