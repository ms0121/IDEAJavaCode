package com.liu.springmvc.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lms
 * @date 2021-09-25 - 20:33
 */

public class MyInterceptor02 extends HandlerInterceptorAdapter {
    /**
     * 在目标方法(handler)执行前  执行
     *
     * @param request
     * @param response
     * @param handler
     * @return true：执行handler（目标）方法，也就是放行
     * false：禁止目标方法的执行
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor02 ==> 目标方法执行之前执行了 ---> preHandle........");
        return true;
    }
}
