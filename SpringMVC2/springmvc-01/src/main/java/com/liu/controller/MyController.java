package com.liu.controller;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author lms
 * @date 2021-04-28 - 9:40
 */

/**
 * @Controller：创建处理器对象，对象放在springmvc容器中
 * 位置：存放在类的上面
 * 和spring中讲的@service， @Component一样，都是创建对象
 * 因为使用了注解，所以必须在springmvc配置文件中声明组件扫描器，即就可以在容器中自动创建对象，从而处理请求
 *
 * 能处理请求的都是控制器（处理器），MyController能处理请求，
 *  叫做后端控制器（back controller）
 *
 */
@Controller
public class MyController {

    /**
     * 准备使用doSome方法进行处理some.do请求。
     *  @RequestMapping：请求映射，作用是把一个请求地址和一个方法绑定在一起。
     *           一个请求指定一个方法处理
     *      属性：1.value值是一个string类型，表示请求的uri地址的(some.do)
     *              value的值必须是唯一的，不能重复，在使用时，推荐地址以 "/"
     *      位置：1.在方法的上面，这是最常用的
     *           2.在类的上面
     *
     *      说明：在使用 RequestMapping 修饰的方法叫做处理器方法或者控制器方法
     *          使用 @RequestMapping修饰的方法可以处理请求的，类似于servlet
     *          中的doGet，doPost方法
     *
     *      方法的返回值：ModelandView 表示本次请求的处理结果
     *          Model：数据，请求处理完成后，要显示给用户的数据信息
     *          View：视图，比如jsp等等
     */
    // 这句话的意思是 dome.do的请求都是交给doSome这个方法进行处理
    @RequestMapping("/some.do")
    public ModelAndView doSome() { // 相当于 doGet() --- Servlet
        // 处理some.do的请求，相当于service调用处理完成了
        ModelAndView mv = new ModelAndView();
        // 添加数据信息，框架在请求的最后把数据放入到request作用域中
        // 下面相当于以前的: request.setAttribute("msg", "欢迎使用springmvc做web开发")
        mv.addObject("msg", "欢迎使用springmvc做web开发");
        mv.addObject("fun","执行的方法是some.do方法");
        // 指定视图，指定跳转的具体的视图完整路径
        // 框架对视图执行的是以前的forward操作，request.getRequestDispatcher("/show.jsp").forward(req, resp)
        // mv.setViewName("/show.jsp");
        // 未配置视图解析器的时候，需要从目录名称开始指定路径的信息
        // mv.setViewName("/WEB-INF/view/show.jsp");

        // 配置视图解析器之后
        mv.setViewName("show");
        // 返回视图信息
        return mv;
    }


    @RequestMapping("/other.do")
    public ModelAndView doOther(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "欢迎使用springmvc做web开发");
        mv.addObject("fun","执行的方法是other.do方法");
        mv.setViewName("other");
        return mv;
    }


}
