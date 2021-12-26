package com.liu.session.controller;

import com.liu.session.vo.ResultInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @author lms
 * @date 2021-10-02 - 16:58
 */
@Controller
public class LoginController {

    @GetMapping("login")
    public String login() {
        return "login";
    }

    @PostMapping("index")
    @ResponseBody
    public ResultInfo index(String username, String password, HttpServletRequest request) {
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        // 判断传递的参数
        ResultInfo resultInfo = new ResultInfo();

        if (StringUtils.isBlank(username)) {
            resultInfo.setCode(500);
            resultInfo.setMsg("用户名不能为空!");
            return resultInfo;
        }

        if (StringUtils.isBlank(password)) {
            resultInfo.setCode(500);
            resultInfo.setMsg("用户密码不能为空!");
            return resultInfo;
        }

        if (!("zhangsan".equals(username) && "123".equals(password))) {
            resultInfo.setCode(500);
            resultInfo.setMsg("用户名或者密码不正确，请重试!");
            return resultInfo;
        }
        // 登录成功
        request.getSession().setAttribute("user", username);
        HashMap<String, Object> map = new HashMap<>();
        map.put("userName", username);
        resultInfo.setData(map);
        return resultInfo;
    }

    // 方式1：直接判断，
    // 页面success只能让登录成功的用户进行访问
//    @GetMapping("success")
    public String success(HttpServletRequest request) {
        // 判断用户是否登录
        String username = (String) request.getSession().getAttribute("user");
        if (StringUtils.isBlank(username)) {
            return "fail";
        }
        return "success";
    }


    // 方式2：使用拦截器进行判断是否登录
    @GetMapping("success2")
    public String success2() {
        return "success";
    }

    // 退出登录
    @GetMapping("logout")
    public String logout(HttpServletRequest request){
        // 直接将session设置为过期，并跳转至登录页面
        request.getSession().invalidate();
        return "login";
    }


}
