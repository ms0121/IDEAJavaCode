package com.liu.bootsql.controller;

import com.liu.bootsql.domain.User;
import com.liu.bootsql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lms
 * @date 2021-11-05 - 10:51
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("user/{id}")
    @ResponseBody
    public User getUser(@PathVariable("id") Integer id){
        return userService.getUser(id);
    }

}
