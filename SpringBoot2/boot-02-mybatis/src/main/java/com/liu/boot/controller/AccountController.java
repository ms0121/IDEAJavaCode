package com.liu.boot.controller;

import com.liu.boot.model.Account;
import com.liu.boot.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lms
 * @date 2021-05-20 - 23:40
 */

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    // id来源于请求参数
    // @RequestParam("id")默认可以不写，默认直接使用的就是来源于请求路径的参数信息
    @GetMapping("/account")
    @ResponseBody
    public Account getAccount(@RequestParam("id") Integer id){
        return accountService.selectByPrimaryKey(id);
    }


    @GetMapping("/account/{name}")
    @ResponseBody
    public String getUser(@PathVariable("name") String name){
        if ("zhangsan".equals(name)){
            return "zhangsan";
        }else {
            return "error";
        }
    }
}
