package com.liu.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lms
 * @date 2021-10-02 - 21:25
 */
@RestController
public class LoginController {

    @GetMapping("login")
    public String login() {
        return "hello SpringSecurity!";
    }
}
