package com.liu.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author lms
 * @date 2021-09-25 - 15:04
 *
 * 过滤器：
 *  1.@WebFilter("/ser01")  配置需要拦截的资源路径
 *  2.doFilter() 方法中需要设置放行，否则请求无法到达资源，即（filterChain.doFilter(servletRequest, servletResponse);）
 *  3.如果有多个过滤器，则先配置的先执行（首字母在前的先执行），响应时顺序反过来
 *
 */
//表示 /ser01 的请求将会经过该过滤器处理之后，才会到达服务器
//@WebFilter("/ser01")
public class Filter01 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter01 init()..........");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 对经过该过滤器的请求进行处理
        System.out.println("Filter01 过滤器。。。。。。。。。。");
        // 处理之后必须放行
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("Filter01 过滤器。。。。。。拦截完成了。。。。");
    }

    @Override
    public void destroy() {
        System.out.println("Filter01 destroy()..........");
    }
}
