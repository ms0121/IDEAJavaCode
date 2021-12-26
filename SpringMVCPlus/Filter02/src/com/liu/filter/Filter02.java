package com.liu.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author lms
 * @date 2021-09-25 - 15:04
 */
//表示 /* (也是就是所有的)的请求将会经过该过滤器处理之后，才会到达服务器
//@WebFilter("/*")  // 表示拦截所有的请求资源路径
public class Filter02 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter02 init()..........");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 对经过该过滤器的请求进行处理
        System.out.println("Filter02 过滤器。。。。。。。。。。");
        // 处理之后必须放行
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("Filter02 过滤器。。。。。。拦截完成了。。。。");
    }

    @Override
    public void destroy() {
        System.out.println("Filter02 destroy()..........");
    }
}
