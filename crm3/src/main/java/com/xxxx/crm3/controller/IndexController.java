package com.xxxx.crm3.controller;

import com.xxxx.crm3.base.BaseController;
import com.xxxx.crm3.service.UserService;
import com.xxxx.crm3.utils.LoginUserUtil;
import com.xxxx.crm3.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author lms
 * @date 2021-09-27 - 16:50
 *
 * 进行页面跳转
 */
@Controller
public class IndexController extends BaseController {

    @Resource
    private UserService userService;


    // 登录界面请求
    @RequestMapping("index")
    public String index(){
        return "index";
    }

    // 欢迎页面
    @RequestMapping("welcome")
    public String welcome(){
        return "welcome";
    }

    /**
     * 用户名和密码正确之后，将会跳转到主页面，即发起main请求，所以在跳转至main页面之前，
     * 将登录用户的信息设置在请求域中
     * @return
     */
    // 主界面
    @RequestMapping("main")
    public String main(HttpServletRequest request){
        // 从cookie中获取登录用户的id
        Integer userId = LoginUserUtil.releaseUserIdFromCookie(request);
        // 根据id查询用户的登录信息
        User user = userService.selectByPrimaryKey(userId);
        // 将用户对象设置在session域中
        request.getSession().setAttribute("user", user);
        return "main";
    }
}
