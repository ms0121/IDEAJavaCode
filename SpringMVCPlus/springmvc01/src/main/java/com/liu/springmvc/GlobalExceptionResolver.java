package com.liu.springmvc;

import com.liu.springmvc.exception.BusinessException;
import com.liu.springmvc.exception.ParamsException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lms
 * @date 2021-09-26 - 11:13
 */
// 为了让当前的全局异常处理类生效，需要将其让IOC容器进行管理
// 方式2： 实现Spring的异常处理接口 HandlerExceptionResolver 从而自定义异常处理器（推荐使用）
// 直接使用注解不生效，不知道为啥，所以需要在SpringMVC的配置文件中进行配置全局异常处理类
// 在自定义的全局异常拦截器中，可以根据自己的需要进行设置不同的异常返回信息
//@Component
//@Component("handlerExceptionResolver")
public class GlobalExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        // 设置默认的异常处理页面
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("ex", "默认错误异常信息!");

        // 判断是否是自定义异常信息
        // 参数异常，跳转至参数异常页面
        if (ex instanceof ParamsException) {
            mv.setViewName("params_error");
            // 获取具体的异常信息
            ParamsException e = (ParamsException) ex;
            mv.addObject("ex", e.getMessage());
        }
//
        // 业务异常，跳转至业务异常页面
        if (ex instanceof BusinessException) {
            mv.setViewName("business_error");
            // 获取具体的异常信息
            BusinessException e = (BusinessException) ex;
            mv.addObject("ex", e.getMessage());
        }

        return mv;
    }
}
