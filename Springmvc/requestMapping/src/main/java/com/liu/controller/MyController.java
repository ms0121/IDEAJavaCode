package com.liu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @RequestMapping
 *      value： 所有请求地址的公共部分，叫做模块名称
 *      位置： 放在类的上面
 */
@Controller
@RequestMapping(value = "/test")
public class MyController {

//    @RequestMapping(value = "/test/some.do")
    @RequestMapping(value = "/some.do")
    public ModelAndView dosome() {    // 类似doGet() ---> servlet请求
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "欢迎使用springmvc做web开发");
        mv.addObject("fun", "指定的是dosome方法");
        mv.setViewName("show");
        return mv;
    }

//    @RequestMapping(value = {"/test/other.do", "/test/second.do"})
    @RequestMapping(value = "other.do")
    public ModelAndView doOther() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "这是一个doOther的方法");
        mv.setViewName("other");
        return mv;
    }
}
