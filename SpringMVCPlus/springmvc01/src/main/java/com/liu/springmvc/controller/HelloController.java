package com.liu.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author lms
 * @date 2021-09-25 - 9:23
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public ModelAndView hello(){

        // 模拟异常（全局异常处理）
//        int i = 1 / 0;

        // 抛出自定义的异常信息
//        if (1 == 1){
//            // 参数异常
////             throw new ParamsException();
//            // 业务异常
//            throw new BusinessException();
//        }

        System.out.println("hello请求被拦截了.........");
        ModelAndView modelAndView = new ModelAndView();
        // 设置数据信息
        modelAndView.addObject("name", "zhangsan");
        // 设置跳转的视图
        modelAndView.setViewName("hello");
        return modelAndView;
    }
}
