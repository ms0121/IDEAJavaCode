package com.liu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author lms
 * @date 2021-04-16 - 23:00
 *
 * @Controller: 创建处理器对象，对象放在springmvc容器中
 *  位置： 在类的上面 和spring中将的 @service， @component类似
 */
@Controller
public class MyController {

    /*
        处理用户的提交的请求，springmvc中使用方法处理的
        方法使用户自定义，可以有多种返回值，多种参数，方法名称可以自定义

        能处理请求的都是控制器（处理器：MyController能处理请求， 叫做后端控制器(back controller)）

     */

    /*
        下列就是使用dosome方法处理index.jsp页面发送过来的some.do请求
        @RequestMapping：请求映射，作用是把一个请求地址和一个方法绑定在一起，
                        一个请求指定一个方法处理
            属性：1. value 是一个spring，表示请求的url地址（比如index.jsp页面的some.do）
                    value值必须是唯一的，不能重复。在使用的时候推荐地址以 "/" 开头
            位置：1. 在方法的上面，推荐使用
                 2. 在类的上面

        说明：使用requestMapping修饰的方法叫做处理器方法或者控制器方法
        使用 @RequestMapping 修饰的方法是可以处理请求，类似于servlet中的doGet， doPost方法

        ModelAndView: 表示本次处理请求的返回结果
        Model： 数据，请求处理结束之后，要显示给用户的数据信息
        View： 视图，比如jsp等等


        一：springmvc请求的处理流程：
               1. 发起some.do请求
               2. Tomcat(web.xml --> url-pattern 知道 *.do 的请求是给中央处理器（dispatcherServlet)
               3. DispatcherServlet （根据springmvc中的配置知道some.do --> 从而指定dosome（））
               4. DispatcherServlet把some.do转发给MyController.doSome()方法
               5. 框架执行doSome()把得到的ModelAndView进行处理，转达到show.jsp

        二: 上面的过程简化方式：
            some.do ----> DispatcherServlet ---> MyController

        三： 中央调度器DispatcherServlet：
            1. 负责创建springmvc容器对象，读取xml配置文件。创建文件中的额Controller对象
            2、负责接收用户的请求，分派给自定义的Controller对象


        四：springmvc执行过程的源代码分析：
            1. Tomcat启动，创建容器的过程：
                通过load-on-start标签指定的1，创建DispatcherServlet对象
                DispatcherServlet它的父类是继承了HttpServlet的，它是一个servlet，再被创建的时候
                会执行init()方法，在init()方法中：
                    1）创建容器，读取配置文件
                    2）把容器对象放入到ServletContext中

                创建容器的作用：创建@Controller注解所在的类的对象，创建Controller对象，
                这个对象放入到springmvc的容器中，容器是map，类似于
                map.put("MyController"，MyController)

            2. 请求的过程：
     */

    // 表示index.jsp页面中的a标签的超链接：some.do 接收到的请求都是交给这个方法（dosome）进行过处理
    // 这里的 斜杠 一定不能丢，它代表根目录，即：http://localhost:8080/springmvc_01/
    @RequestMapping(value = "/some.do")
    public ModelAndView dosome() {    // 类似doGet() ---> servlet请求
        // 处理some.do 请求，就相当于service调用处理完成了，
        ModelAndView mv = new ModelAndView();
        // 添加数据信息，框架在请求的最后把数据放入到request作用域中
        // 下面的添加操作相当于： request.setAttribute("msg", "欢迎使用springmvc做web开发")
        mv.addObject("msg", "欢迎使用springmvc做web开发");
        mv.addObject("fun", "指定的是dosome方法");

        // 指定视图，指定视图的完整路径
        // 框架对视图执行的forward操作：
        // 下面的作用就相当于请求转发： request.getRequestDispather("/show.jsp").forward(....)
        // mv.setViewName("/show.jsp");

        // 如果不使用视图解析器，需要使用完整的路径名称
        // mv.setViewName("/WEB-INF/view/show.jsp");

        // 使用视图解析器后，可以使用逻辑名称（文件名），指定视图
        // 框架会使用视图解析器的前缀 + 逻辑名称 + 后缀 组成完整的路径，这里就是字符连接操作
        // /WEB-INF/view/ + show + .jsp
        mv.setViewName("show");
        return mv; // 返回
    }

    // value的值是一个数组，可以设置多个请求执行同一个方法
    @RequestMapping(value = {"/other.do", "/second.do"})
    public ModelAndView doOther() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "这是一个doOther的方法");
        mv.setViewName("other");
        return mv;
    }

}
