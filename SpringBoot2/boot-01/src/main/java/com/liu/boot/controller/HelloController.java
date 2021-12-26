package com.liu.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author lms
 * @date 2021-05-16 - 9:52
 */

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello, SpringBoot!";
    }

    @GetMapping("/user")
    public String get(){
        return "get";
    }

    @PostMapping("/user")
    public String post(){
        return "post";
    }

    @PutMapping("/user")
    public String put() {
        return "put";
    }

    @DeleteMapping("/user")
    public String delete() {
        return "delete";
    }
}
