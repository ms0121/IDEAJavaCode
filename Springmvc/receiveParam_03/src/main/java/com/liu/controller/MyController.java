package com.liu.controller;

import com.liu.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

    /**
     *1. 这个逐个接收请求参数:
     *      要求：处理器（控制器）方法的形参名和请求中参数名必须一致
     *          ***主要** 同名的请求参数赋值给同名的形参
     *
     * 2. 框架接收请求参数：
     *      1. 使用request对象接收请求参数，如
     *      String strName = request.getParameter("name")
     *      String strAge = request.getParameter("age")
     *
     *      2.springmvc框架通过DispatcherServlet调用MyController的doSom()
     *      方法，调用方法时，按名称对应，把接受的参数赋值给形参
     *          doSome(strName, Integer.valueOf(strAge))
     *      框架会自动的提供类型转换的功能，能把string转为int，float，double等等
     *
     * 400：状态码是客户端错误，表示提交请求参数过程中，发生了问题
     */
    @RequestMapping(value = "/first.do")  // 当前的响应是 first.do 请求
    public ModelAndView doSome(String name, Integer age) {   // 这里的参数必须和index页面的设置的形参名一样
        // 所以现在就可以直接在方法中直接使用name，age
        ModelAndView mv = new ModelAndView();
        mv.addObject("myname", name);
        mv.addObject("myage", Integer.valueOf(age));
        // 设置跳转到first.jsp页面处理业务
        mv.setViewName("first");
        return mv;
    }


    // 当前测试请求的参数名和控制器的形参名不一致，的解决方法

    /**
     * @RequestParam: 这个接收请求的参数中，解决请求中参数名形参名不一样的问题
     *      属性：1. value 请求参数中的参数名称
     *            2. required 表示请求中必须包含此参数。默认true
     *      位置： 放置在处理器方法的形参定义的前面
     */
    @RequestMapping(value = "/receiveParam.do")   // 意思是把请求的参数rname赋值给name
    public ModelAndView receiveParam(@RequestParam(value = "rname", required = false) String name,
                                     @RequestParam(value = "rage", required = false) Integer age) {
        // 所以现在就可以直接在方法中直接使用name，age 
        ModelAndView mv = new ModelAndView();
        mv.addObject("myname", name);
        mv.addObject("myage", Integer.valueOf(age));
        // 设置跳转到first.jsp页面处理业务
        mv.setViewName("first");
        return mv;
    }

    /**
     * 处理器方法是java对象，这个对象的属性名和请求中的参数名是一致的
     * 框架会自动的创建java对象，给属性进行赋值，请求中的参数是name，框架会调用setName()
     */
    @RequestMapping(value = "/receiveObject.do")   // 意思是把请求的参数rname赋值给name
    public ModelAndView receiveObject(Student student) {
        // 所以现在就可以直接在方法中直接使用name，age
        ModelAndView mv = new ModelAndView();
        // 给属性进行赋值
        mv.addObject("myname", student.getName());
        mv.addObject("myage", student.getAge());
        mv.addObject("student", student);
        // 设置跳转到first.jsp页面处理业务
        mv.setViewName("first");
        return mv;
    }

}
