package com.liu.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lms
 * @date 2021-05-16 - 15:46
 */
@Controller
public class IndexController {

    @GetMapping("/goto")
    public String toIndex(HttpServletRequest request) {
        request.setAttribute("msg","请求成功了.........");
        request.setAttribute("code", 200);
        return "forward:/success"; // 请求转发到另外一个页面
    }


    @ResponseBody
    @GetMapping("/success")
    public Map<String, Object> getRe(HttpServletRequest request,
                                     @RequestAttribute("msg") String msg,
                                     @RequestAttribute("code") String code){
        String msg1 = (String) request.getAttribute("msg");
        String code1 = (String) request.getAttribute("code");

        HashMap<String, Object> map = new HashMap<>();
        map.put(msg1, msg);
        map.put(code1, code);
        System.out.println(msg);
        System.out.println("code = " + code);
        return map;
    }

}
