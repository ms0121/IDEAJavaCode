package com.liu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/user")
public class MyController2 {

    /**
     *  @RequestMapping：请求映射
     *          属性：method，表示请求的方式，它的值RequestMethod类是枚举类型
     *          例如表示get请求的方式:method = RequestMethod.GET
     *          post请求的方式:method = RequestMethod.POST
     */
    @RequestMapping(value = "/some.do", method = RequestMethod.GET)
    public ModelAndView dosome() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "这是some.do的get请求方法");
        mv.addObject("fun", "指定的是dosome方法");
        mv.setViewName("show");
        return mv;
    }

    // 使用了post请求必须使用表单提交的方式
    // 设置了请求方式必须使用相应的请求方法进行访问，如果不使用请求的方法，则访问没有限制
    @RequestMapping(value = "/other.do", method = RequestMethod.POST)
    public ModelAndView doOther() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "这是一个doOther的post请求方法");
        mv.setViewName("other");
        return mv;
    }

    @RequestMapping(value = "first.do")
    public ModelAndView doFirst(HttpServletRequest request, HttpServletResponse response,
                                HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "first方法执行了, 得到的参数是: "
                + request.getParameter("name"));
        mv.setViewName("first");
        return mv;
    }
}
