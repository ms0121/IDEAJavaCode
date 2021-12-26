package com.liu.ssm.controller;

import com.liu.ssm.domain.User;
import com.liu.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lms
 * @date 2021-11-05 - 10:51
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("user")
    public List<User> getUser(){
        return userService.getUser();
    }

    @GetMapping("add")
    public String add(){
        User user = new User();
        user.setUsername("jd14");
        user.setPassword("1004");
        user.setEmail("133@jd.com");
        userService.add(user);
        return "添加用户成功";
    }

}
