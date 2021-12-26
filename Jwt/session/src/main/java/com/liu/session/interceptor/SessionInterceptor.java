package com.liu.session.interceptor;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author lms
 * @date 2021-10-02 - 19:37
 */
@Component
public class SessionInterceptor implements HandlerInterceptor {
    /**
     * 在目标方法执行 之前执行
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取Session中的信息，判断用户是否登录
        String username = (String) request.getSession().getAttribute("user");
        // 如果session中存在用户信息，则放行
        if (!StringUtils.isBlank(username)){
            return true;
        }
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("您还未登录，请登录!");
        // 否则拦截当前的请求信息
        return false;
    }
}
