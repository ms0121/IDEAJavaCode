package com.liu.controller;

import com.liu.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
//@RequestMapping("/test")
public class MyController {
    /**
     * @RequestMapping：请求映射
     *      属性：method，表示请求的方式，它的值是RequestMapping类型的枚举
     *          例如表示get请求，RequestMapping.GET,,,,,,
     *      ，指定什么请求方式就用什么请求方式去访问
     *
     *  处理器函数会逐个接收请求参数:
     *      * 要求：处理器（控制器）方法的形参名和请求中的参数名必须一致，
     *              同名的请求参数赋值给同名的参数
     *
     *   框架接受请求参数的方式：
     *      1. 使用request对象接收请求参数
     *           string strName = request.getParameter("name")
     *           string strAge = request.getParameter("age")
     *           （这里的strName代表的是请求页面表单中的对应的文本框设置的形参名name属性的值）
     *      2. springmvc框架通过 DispatcherServlet调用MyController类的doSome()方法
     *           doSome(strName， Integer.valueOf(strAge))
     *           框架会提供类型转换的功能，能够直接把string转为int，long，float等类型
     *
     *      3. 400状态码是客户端错误，表示请求提交参数过程中，发生了问题
     */
    @RequestMapping(value = "/some.do")
    public ModelAndView doSome(String name, Integer age) {
        // 当前的形参name，age已经被赋完值了，所以可以直接使用，不需要在重新进行定义
        // 处理some.do的请求，相当于service调用处理完成了
        ModelAndView mv = new ModelAndView();
        mv.addObject("myname", name);
        mv.addObject("myage",age);
        mv.setViewName("show");
        return mv;
    }

    /**
     *  当请求中参数名和处理器函数中的形参名不一致无法赋值的解决方法：
     *  @RequestParam：逐个接收请求参数中，解决请求中参数名和处理器函数中（该参数只适用于逐个接收参数里面）
     *                  形参名不一致的问题
     *      属性：1. value: 请求中的参数名称
     *           2. required: 是一个boolean值，默认是true，
     *                  true：表示请求中必须包含此参数
     *      位置：在处理器方法的形参定义的前面
     *
     *
     *  @RequestParam("rname") String name:意思就是将页面中的人rname变量的值赋给形参变量name，解决处理器方法和请求中的参数
     *                          不一致出现的问题
     */
    @RequestMapping("/some1.do")
    public ModelAndView doSome1(@RequestParam(value = "rname", required = false) String name,
                                @RequestParam(value = "rage", required = false) Integer age) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("myname", name);
        mv.addObject("myage", age);
        mv.setViewName("show");
        return mv;
    }


    /**
     * 1. 处理器方法形参是java对象，要求: 这个对象的属性名和请求参数名一致
     * 2。 框架会自动创建形参java对象，给属性进行赋值，请求中的参数是name，框架
     *      就会调用setName()方法进行赋值
     */
    @RequestMapping("/some2.do") // 对象接收的方式
    public ModelAndView doSome2(Student student) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("myname", student.getName());
        mv.addObject("myage", student.getAge());
        mv.addObject("student", student);
        mv.setViewName("show");
        return mv;
    }

}












