package com.liu.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lms
 * @date 2021-09-23 - 20:22
 */
@Controller
public class TestController {

    @RequestMapping("/")
    public String index(){
        return "test";
    }

    @RequestMapping("/test1")
    public String test(String str, HttpServletRequest request){
//        // 123
        System.out.println("str = " + str);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            builder.append(str.charAt(i));
        }
        StringBuilder builder1 = builder.reverse();
        String string = builder1.toString();
        request.setAttribute("str", string);
        return "demo";
    }
}
