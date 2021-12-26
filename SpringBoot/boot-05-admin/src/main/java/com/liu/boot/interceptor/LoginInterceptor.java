package com.liu.boot.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author lms
 * @date 2021-05-18 - 19:38
 *
 * 登录拦截器，验证用户的登录信息是否正确（符合要求）
 * 使用的步骤：
 * 1.配置好拦截器要拦截哪些请求
 * 2.把拦截器配置放入容器中
 *
 */
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 目标方法执行之前
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 登录逻辑检查
        HttpSession session = request.getSession();
        Object user = session.getAttribute("loginUser");
        if (user != null){
            // 放行
            return true;
        }
        // 拦截，未登录，重定向跳转到登录页
        session.setAttribute("msg", "请先登录");
        response.sendRedirect("/");
        return false;
    }

    /**
     * 目标方法执行之后
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {


    }

    /**
     * 页面渲染以后
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
