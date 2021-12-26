package com.liu.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author lms
 * @date 2021-09-25 - 11:40
 *
 * 请求域对象的设置方式（五种）：
 *
 */
@Controller
@RequestMapping("model")
public class ModelController {

    /**
     * ModelAndView设置域对象
     * @return
     */
    @RequestMapping("/test01")
    public ModelAndView test01(){
        ModelAndView modelAndView = new ModelAndView();
        // 设置请求域对象
        modelAndView.addObject("name", "hello model-1");
        // 设置视图
        modelAndView.setViewName("hello");
        return modelAndView;
    }

    /**
     * Model设置域对象
     * @return
     */
    @RequestMapping("/test02")
    public String test02(Model model){
        // 设置请求域对象
        model.addAttribute("name", "hello model-2");
        // 设置视图
        return "hello";
    }

    /**
     * ModelMap设置域对象
     * @return
     */
    @RequestMapping("/test03")
    public String test03(ModelMap model){
        // 设置请求域对象
        model.addAttribute("name", "hello model-3");
        // 设置视图
        return "hello";
    }


    /**
     * ModelMap设置域对象
     * @return
     */
    @RequestMapping("/test04")
    public String test04(Map model){
        // 设置请求域对象
        model.put("name", "hello model-4");
        // 设置视图
        return "hello";
    }

    /**
     * ModelMap设置域对象
     * @return
     */
    @RequestMapping("/test05")
    public String test05(HttpServletRequest request){
        // 设置请求域对象
        request.setAttribute("name", "hello model-5");
        // 设置视图
        return "hello";
    }

}
