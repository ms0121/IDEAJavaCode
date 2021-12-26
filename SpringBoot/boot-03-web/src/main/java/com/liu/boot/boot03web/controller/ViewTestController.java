package com.liu.boot.boot03web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author lms
 * @date 2021-05-10 - 11:35
 */

@Controller
public class ViewTestController {

    @GetMapping("/view")
    public String getSuccess(Model model) {
//        Model中的数据会被放在请求域中，就相当于之前的request.setAttribute("a", aaa);
        model.addAttribute("msg", "你好SpringBoot！");
        model.addAttribute("msg2", "这个第二个信息");
        model.addAttribute("link", "http://www.baidu.com");
        return "first";
    }
}
