package com.liu.shrio.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lms
 * @date 2021-05-28 - 18:25
 */

@Controller
public class ShiroController {

    @RequestMapping("/")
    public String index() {
        return "login";
    }

    @RequestMapping("/login")
    public String login(String username, String password, Model model) throws UnknownAccountException {
        // 获取权限操作的对象(Subject)，利用这个对象来完成登录的操作
        Subject subject = SecurityUtils.getSubject();

        System.out.println("password = " + password);

        // 用户是否已经认证过(是否登录),进入id则表示没有认证，则需要进行认证
        if (!subject.isAuthenticated()) {
            // 创建用户认证时的身份令牌，并封装页面传过来的账号和密码在身份令牌中
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);

            try {
                /**
                 * 使用用户令牌进行登录，指定登录，会自动的调用我们的Realm对象中的认证方法
                 * 如果登录失败会抛出各种异常信息
                 */
                subject.login(usernamePasswordToken);
            } catch (UnknownAccountException e) {
                model.addAttribute("errorMessage", e.getMessage());
                return "login";
            } catch (LockedAccountException e) {
                model.addAttribute("errorMessage", e.getMessage());
                return "login";
            } catch (IncorrectCredentialsException e){
                model.addAttribute("errorMessage", "密码错误");
                return "login";
            } catch (AuthenticationException e) {
                // 登陆失败，返回登录页面
                model.addAttribute("errorMessage", "认证失败!");
                return "login";
            }
        }
        return "redirect:/success";
    }

    @RequestMapping("/success")
    public String loginSuccess() {
        return "success";
    }

    @RequestMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        // 退出登录，清空shiro当前用户的缓存，否则无法重新登录
        subject.logout();
        return "redirect:/";
    }

    @RequestMapping("/noPermission")
    public String permission() {
        return "noPermission";
    }

    @RequestMapping("/admin/test")
    @ResponseBody
    public String adminTest() {
        return "/admin/test/请求";
    }


    @RequestMapping("/user/test")
    @ResponseBody
    public String userTest() {
        return "/user/test请求";
    }

}












