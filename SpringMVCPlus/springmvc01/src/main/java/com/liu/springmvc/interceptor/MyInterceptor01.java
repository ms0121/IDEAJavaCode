package com.liu.springmvc.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lms
 * @date 2021-09-25 - 19:36
 * 实现拦截器HandlerInterceptor的接口，并重写3个方法
 */

public class MyInterceptor01 implements HandlerInterceptor {
    /**
     * 在目标方法执行前  执行
     * @param request
     * @param response
     * @param handler
     * @return true：执行handler（目标）方法，也就是放行
     *         false：禁止目标方法的执行
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor01 ==> 目标方法之前执行了 ---> preHandle........");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("目标方法执行之后，视图生成之前，执行了 ---> postHandle........");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("目标方法执行之后，视图生成之后，执行了 ---> afterCompletion........");
    }
}
