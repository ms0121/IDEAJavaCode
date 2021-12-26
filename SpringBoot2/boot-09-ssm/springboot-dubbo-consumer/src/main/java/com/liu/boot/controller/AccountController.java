package com.liu.boot.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.liu.boot.model.Account;
import com.liu.boot.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lms
 * @date 2021-05-23 - 22:45
 */

@Controller
public class AccountController {

    @Reference(interfaceClass = AccountService.class, version = "1.0.0")
    private AccountService accountService;

    @RequestMapping("/account/count/{id}")
    @ResponseBody
    public Account count(Model model, @PathVariable("id") Integer id){
        Account account = accountService.queryAccount(id);
        model.addAttribute("account", account);
        return account;
    }


    // 查询总的记录数
    @RequestMapping("/account/all/count")
    @ResponseBody
    public Integer queryAllAccountCount() {
        Integer count = accountService.queryAllAccountCount();
        return count;
    }




}
