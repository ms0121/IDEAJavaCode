package com.liu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author lms
 */

/**
 * @RequestMapping("/test"):放置在类的上面，表示所有请求的公共部分
 *      value: 所有请求的公共部分，叫做模块名称
 *      位置：放在类的上面
 */
@Controller
@RequestMapping("/test")
public class MyController {

    /**
     * @RequestMapping：请求映射
     *      属性：method，表示请求的方式，它的值是RequestMapping类型的枚举
     *          例如表示get请求，RequestMapping.GET,,,,,,
     *      ，指定什么请求方式就用什么请求方式去访问
     */
    @RequestMapping(value = "/some.do", method = RequestMethod.GET)
    public ModelAndView doSome() { // 相当于 doGet() --- Servlet
        // 处理some.do的请求，相当于service调用处理完成了
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "欢迎使用springmvc做web开发");
        mv.addObject("fun","执行的方法是some.do方法");
        mv.setViewName("show");
        return mv;
    }


    @RequestMapping(value = "/other.do", method = RequestMethod.POST)
    public ModelAndView doOther(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "欢迎使用springmvc做web开发");
        mv.addObject("fun","执行的方法是other.do方法");
        mv.setViewName("other");
        return mv;
    }

    // 不指定请求访问的方式,访问无限制
    @RequestMapping("/first.do")
    public ModelAndView doFirst(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "欢迎使用springmvc做web开发");
        mv.addObject("fun","执行的方法是other.do方法");
        mv.setViewName("other");
        return mv;
    }


}
