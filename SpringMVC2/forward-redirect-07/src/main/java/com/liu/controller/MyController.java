package com.liu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MyController {

    /**
     * 处理器方法返回ModelAndView,实现forward的请求转发，
     * 语法：setView("forward:视图文件完整路径");
     * forward特点：不合适图解析器一起使用，就当项目中没有视图解析器
     */
    @RequestMapping(value = "/forward.do")
    public ModelAndView doSome(String name, Integer age) {
        System.out.println("接收到了请求参数: \n name:" + name + "\n age:" + age);
        ModelAndView mv = new ModelAndView();
        mv.addObject("myname", name);
        mv.addObject("myage", age);
        // 直接使用forward请求转发的操作，显示转发
        // mv.setViewName("forward:/WEB-INF/view/show.jsp");

        // 也可以访问别的资源数据信息
        mv.setViewName("forward:/show1.jsp");
        return mv;
    }


    /**
     * 处理器方法返回ModelAndView,实现redirect的重定向操作，
     * 语法：setView("redirect:视图文件完整路径");
     * redirect特点：不合适图解析器一起使用，就当项目中没有视图解析器
     *
     * 框架对重定向的操作：
     *  1. 框架会把Model中的简单类型的数据，转为string进行使用，作为show1.jsp的
     *     get请求参数使用，目的是在redirect.do和show1.jsp两次请求之间传递数据
     */
    @RequestMapping(value = "/redirect.do")
    public ModelAndView doSome2(String name, Integer age) {
        System.out.println("接收到了请求参数: \n name:" + name + "\n age:" + age);
        ModelAndView mv = new ModelAndView();
        mv.addObject("myname", name);
        mv.addObject("myage", age);
        // 也可以访问别的资源数据信息
        // 发送的数据无法被访问，原因是发起了两次请求的操作
        mv.setViewName("redirect:/show1.jsp");
        // 重定向无法访问WEB_INF下的数据信息（即下面的访问会出现错误）
        // mv.setViewName("redirect:/WEB-INF/view/show.jsp");
        return mv;
    }
}












