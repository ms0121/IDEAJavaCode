package com.xxxx.crm3;

import com.alibaba.fastjson.JSON;
import com.xxxx.crm3.base.ResultInfo;
import com.xxxx.crm3.exceptions.NoLoginException;
import com.xxxx.crm3.exceptions.ParamsException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author lms
 * @date 2021-09-29 - 21:54
 * 全局异常处理器
 */
@Component
public class GlobalExceptionResolver implements HandlerExceptionResolver {
    /**
     *  Controller中函数的返回值类型：
     *                    视图
     *                    JSON
     *  如何判断方法的返回类型： 通过 @ResponseBody 注解进行判断当前方法返回的是JSON，如果当前返回的注解对象为
     *      空，说明当前方法返回的是视图；
     *
     * @param request
     * @param response
     * @param handler 目标执行方法
     * @param e 异常信息
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) {

        // 未登录异常信息处理
        if (e instanceof NoLoginException){
            // 如果捕获的是未登录异常，则重定向到登录页面
            ModelAndView modelAndView = new ModelAndView("redirect:/index");
            return modelAndView;
        }


        ModelAndView modelAndView = new ModelAndView();
        // 设置默认的异常处理方式
        // 默认不跳转到指定视图
        modelAndView.setViewName("");
        modelAndView.addObject("code", 400);
        modelAndView.addObject("msg", "系统异常，请稍后再试.......");

        // 判断handler是否是HandlerMethod类型的
        if (handler instanceof HandlerMethod){
            // 强制转换目标方法的类型
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            // 先获取到当前方法，然后获取方法上的指定类型的注解
            ResponseBody responseBody = handlerMethod.getMethod().getDeclaredAnnotation(ResponseBody.class);

            // 根据获取到的 ResponseBody 进行判断对象是否存在，如果对象存在则表示当前的方法返回的是json数据，否则为视图
            if (responseBody == null){
                // 返回的是视图,并判断异常的类型
                if (e instanceof ParamsException){
                    ParamsException p = (ParamsException) e;
                    modelAndView.addObject("code", p.getCode());
                    modelAndView.addObject("msg", p.getMsg());
                }
                return modelAndView;
            } else {
                // 表示发生异常的方法,返回的是json数据
                // 非自定义异常信息
                ResultInfo resultInfo = new ResultInfo();
                resultInfo.setCode(300);
                resultInfo.setMsg("系统异常，请稍后再试.......");

                // 自定义异常信息
                if (e instanceof ParamsException){
                    ParamsException p = (ParamsException) e;
                    resultInfo.setCode(p.getCode());
                    resultInfo.setMsg(p.getMsg());
                }

                // 设置响应的类型和编码格式（响应的是json数据）
                response.setContentType("application/json;charset=utf-8");
                // 得到输出流
                PrintWriter out = null;
                try {
                    out = response.getWriter();
                    // 将对象转为json格式，通过输出流输出
                    out.write(JSON.toJSONString(resultInfo));
                    out.flush();
                } catch (Exception ex){
                    ex.printStackTrace();
                } finally{
                    if (out != null){
                        out.close();
                    }
                }
                return null;
            }
        }
        return modelAndView;
    }
}
