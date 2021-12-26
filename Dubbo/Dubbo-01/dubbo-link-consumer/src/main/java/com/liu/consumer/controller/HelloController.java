package com.liu.consumer.controller;

import com.liu.provider.service.SomeService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author lms
 * @date 2021-05-23 - 13:26
 */

@Controller
public class HelloController {

    @Resource
    private SomeService someService;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(Model model){
        String hello1 = someService.Hello("Dubbo");
//        model.addAttribute("hello", hello);
        return hello1;
    }
}
