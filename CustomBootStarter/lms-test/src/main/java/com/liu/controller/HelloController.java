package com.liu.controller;

import com.liu.boot.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lms
 * @date 2021-11-03 - 22:52
 */
@Controller
public class HelloController {
    // 此HelloService是被注入到我们自定义的starter容器中
    @Autowired
    private HelloService helloService;

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return helloService.sayHello();
    }

}
