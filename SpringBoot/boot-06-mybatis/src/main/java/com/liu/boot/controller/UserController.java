package com.liu.boot.controller;

import com.liu.boot.bean.User;
import com.liu.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author lms
 * @date 2021-05-19 - 9:18
 */

@RestController
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/user")
    public User queryForUserById(@RequestParam("id") Integer id){
        User user = userService.queryForUserById(id);
        return user;
    }

}
