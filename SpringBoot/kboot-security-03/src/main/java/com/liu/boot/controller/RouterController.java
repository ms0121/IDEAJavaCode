package com.liu.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author lms
 * @date 2021-05-13 - 10:19
 */

@Controller
public class RouterController {

    @GetMapping({"/", "index"})
    public String index(){
        return "index";
    }

    @GetMapping("/toLogin")
    public String login(){
        return "views/login";
    }

    @GetMapping("/level1/{id}")
    public String level1(@PathVariable("id") Integer id){
        return "views/level1/"+id;
    }


    @GetMapping("/level2/{id}")
    public String level2(@PathVariable("id") Integer id){
        return "views/level2/"+id;
    }

    @GetMapping("/level3/{id}")
    public String level3(@PathVariable("id") Integer id){
        return "views/level3/"+id;
    }

}
