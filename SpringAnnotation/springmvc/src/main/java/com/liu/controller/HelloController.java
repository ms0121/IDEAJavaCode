package com.liu.controller;

import com.liu.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lms
 * @date 2021-05-08 - 15:50
 */

@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        String s = helloService.sayHello("方法被执行了............");
        return s;
    }


    @RequestMapping("/suc")
    @ResponseBody
    public String success() {
        return "success";
    }


}
