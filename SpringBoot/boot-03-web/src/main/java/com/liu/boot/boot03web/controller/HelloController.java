package com.liu.boot.boot03web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lms
 * @date 2021-05-09 - 17:46
 */

@RestController
public class HelloController {

    @RequestMapping("/test1.jpg")
    public String name() {
        return "你好吗？利路修老师!";
    }
}
