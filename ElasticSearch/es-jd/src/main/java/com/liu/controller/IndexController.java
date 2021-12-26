package com.liu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author lms
 * @date 2021-10-31 - 15:15
 */
@Controller
public class IndexController {

    @GetMapping({"/", "index"})
    public String index(){
        return "index";
    }

}
