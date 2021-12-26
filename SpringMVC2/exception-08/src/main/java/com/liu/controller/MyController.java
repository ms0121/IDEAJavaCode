package com.liu.controller;

import com.liu.exception.AgeException;
import com.liu.exception.MyException;
import com.liu.exception.NameException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MyController {

    @RequestMapping("/some.do")
    public ModelAndView doSome(String name, Integer age) throws MyException {
        ModelAndView mv = new ModelAndView();
        if (!"zhangsan".equals(name)){
            throw new NameException("名字不正确!");
        }

        if (age == null || age > 80){
            throw new AgeException("年龄太大了");
        }
        mv.addObject("myname", name);
        mv.addObject("myage", age);
        mv.setViewName("show");
        return mv;
    }

}












