package com.liu.boot.Interceptor;

import com.liu.boot.bean.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lms
 * @date 2021-05-21 - 15:20
 * 自定义拦截器类，实现 HandlerInterceptor 接口 ，等价于之前写的配置文件xml的方式配置的拦截器方式
 * 配置好了拦截器类，还需要把拦截器类注入到
 */

public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null){
            // 用户未登录，直接拦截
            response.sendRedirect(request.getContextPath() + "/user/error");
            return false;
        }
        // 登录之后放行
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
