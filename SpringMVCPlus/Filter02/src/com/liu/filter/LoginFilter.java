package com.liu.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lms
 * @date 2021-09-25 - 17:25
 * 过滤器实现的登录拦截：
 * <p>
 * 模拟登录拦截器：用户未登录，禁止访问指定的资源
 * 非法访问拦截：
 * 拦截的资源: 拦截所有的资源 /*
 * 需要放行的资源：
 * 1.指定页面进行放行（无需登录就可以访问的页面，例如：登录页面，注册页面等）
 * 2.静态资源需要放行（比如:images,js,css文件）
 * 3.指定操作，放行（无需登录即可执行的操作，例如：登录操作，注册操作）
 * 4.如果当前是登录状态，放行（通过判断session中的用户信息是否为空）
 * <p>
 * 如果上面的状态都不执行，就拦截让其重定向到登录页面
 */
//拦截所有的请求路径
@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    // 在这里设置需要被放行的路径信息（即不登录也可以访问的资源/页面）
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 基于http请求
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 获取用户访问的路径
        String uri = request.getRequestURI();
        System.out.println("uri = " + uri);

        // 1.指定页面进行放行（无需登录就可以访问的页面，例如：登录页面，注册页面等）
        if (uri.contains("/login.jsp")) {
            filterChain.doFilter(request, response);
            return;
        }

        // 2.静态资源需要放行（比如:images,js,css文件）
        if (uri.contains("/js") || uri.contains("/css") || uri.contains("/images")) {
            filterChain.doFilter(request, response);
            return;
        }

        // 3.指定操作，放行（无需登录即可执行的操作，例如：登录操作，注册操作）
        if (uri.contains("/login")) {
            filterChain.doFilter(request, response);
            return;
        }

        // 4.是登录状态，放行（判断session中的用户信息是否为空）
        // 从session中获取保存的域对象信息
        String user = (String) request.getSession().getAttribute("user");
        // 判断user对象是否为空，不为空，这说明已经是登录状态,则放行
        if (user != null) {
            filterChain.doFilter(request, response);
            return;
        }

        // 当用户未登录时，所有的非法访问拦截请求都会被重定向跳转到登录页面，登录之后才能访问其他资源
        response.sendRedirect("login.jsp");
    }

    @Override
    public void destroy() {

    }
}
