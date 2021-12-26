package com.liu.springmvc.controller;

import com.sun.xml.internal.ws.api.pipe.helper.AbstractFilterTubeImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author lms
 * @date 2021-09-25 - 11:56
 *
 * 请求转发和重定向的区别
 */
@Controller
@RequestMapping("/rr")
public class RRController {

//   请求转发(默认)
    @RequestMapping("/test01")
    public String test01(){
        // 只能请求转发到项目内部的资源，
        return "hello";
    }

//    重定向,请求域对象中的数据无法共享（因为使用了两次请求）
    @RequestMapping("/test02")
    public String test02(Model model){
        model.addAttribute("myname", "lisi");
        return "redirect:/rr.jsp?name=zhangsan&age=20";
    }


    //    请求转发(使用forward可以到指定的页面)
    @RequestMapping("/test03")
    public String test03(HttpSession session){
        session.setAttribute("myname", "lisi");
        return "forward:/rr.jsp?name=zhangsan&age=20";
    }
}
