package com.liu.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lms
 * @date 2021-05-19 - 9:31
 */
@RestController
public class LoginController {

    @GetMapping({"/","/index"})
    public String login(){
        return "index";
    }
}
