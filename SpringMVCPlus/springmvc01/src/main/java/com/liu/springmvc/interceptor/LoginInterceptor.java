package com.liu.springmvc.interceptor;

import com.liu.springmvc.bean.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lms
 * @date 2021-09-25 - 21:32
 */
//拦截器（类似于过滤器）
public class LoginInterceptor extends HandlerInterceptorAdapter {
    /**
     * 指定目标方法之前执行该方法
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取session中的user信息
        User user = (User) request.getSession().getAttribute("user");
        // 未登录
        if (user == null) {
            // 重定向到登录页面
            response.sendRedirect(request.getContextPath() + "/" + "login.jsp");
            // 禁止执行请求
            return false;
        }
        // 否则放行，执行目标方法
        return true;
    }
}
