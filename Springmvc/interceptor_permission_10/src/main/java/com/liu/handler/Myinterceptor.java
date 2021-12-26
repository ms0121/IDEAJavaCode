package com.liu.handler;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Time;
import java.util.Date;

/**
 * @author lms
 * @date 2021-04-18 - 20:06
 */

//拦截器类：拦截用户的请求
public class Myinterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        System.out.println("11111-拦截器MyInterceptor的preHandle()方法！");
        Object str = request.getSession().getAttribute("name");
        String nameStr = "";

        if (str != null){
            nameStr = (String) str;
        }

        // 判断用户是否正确
        if (!("zhangsan".equals(nameStr))){
            request.getRequestDispatcher("/tips.jsp").forward(request, response);
            return false;
        }

        return true;
    }
}
