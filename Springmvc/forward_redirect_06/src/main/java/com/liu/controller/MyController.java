package com.liu.controller;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sun.management.Agent;

@Controller
public class MyController {

    /**
     * 处理器方法返回ModelAndView，实现转发forward
     * 语法：setViewName("forward:视图完整的路径信息")
     * forward的特点：不和视图解析器一起工作
     */
    @RequestMapping(value = "/forward.do")
    public ModelAndView doSome(String name, Integer age) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("myname", name);
        mv.addObject("myage", Integer.valueOf(age));
//        使用视图，在web_inf外面的页面信息，直接使用视图解析器无法无法访问
//        mv.setViewName("first");

//        不使用视图解析器 / 代表到：当前工程路径(即到/webapp/)
        mv.setViewName("forward:/WEB-INF/view/first.jsp");
//        mv.setViewName("forward:/first2.jsp");  // 把first.jsp移动到webapp目录之下
        return mv;
    }


    /**
     * 处理器方法返回ModelAndView，实现了重定向redirect
     * 语法：setViewName("redirect：视图完整的路径信息")
     * redirect特点：不和视图解析器一起使用，就当项目中没有视图解析器
     *
     * 框架对于重定向的操作：
     *  1. 框架会把model中的简单数据类型，转为string使用，作为hello.jsp的get请求参数使用
     *      目的是在doRedirect.do 和 first2.jsp两次请求之间传递参数
     *
     *  2. 在目标first2.jsp页面可以使用参数集合对象 $(apram)获取请求参数
     *      $(param.myname)
     *
     *  3. 重定向不可以访问 /WEB-INF下的所有资源
     *
     */
    @RequestMapping(value = "/redirect.do")
    public ModelAndView doRedirect(String name, Integer age) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("myname", name);
        mv.addObject("myage", age);
        mv.setViewName("redirect:/first2.jsp");
        return mv;
    }

}
