package com.liu.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author lms
 * @date 2021-04-09 - 9:33
 */
public class AdminFilter implements Filter {

    public AdminFilter(){
        System.out.println("构造器方法");
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter的初始化!");
        //        FilterConfig 类的作用是获取 filter 过滤器的配置内容

        //        1、获取 Filter 的名称 filter-name 的内容
        System.out.println("filter-name的名字: " + filterConfig.getFilterName());

        //        2、获取在 Filter 中配置的 init-param 初始化参数
        String username = filterConfig.getInitParameter("username");
        System.out.println("username = " + username);
        String url = filterConfig.getInitParameter("url");
        System.out.println("url = " + url);

        //        3、获取 ServletContext 对象
        System.out.println("ServletContext： " + filterConfig.getServletContext());
    }

    /**
     * 专门用于拦截请求，可以做权限管理的操作
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("doFilter方法");

        // 通过session获取存放在session域中的用户登录信息
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        Object user = httpServletRequest.getSession().getAttribute("user");

        if (user == null){
            // 如果用户没有登录，则直接跳转到指定的登录界面
            servletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest, servletResponse);
            return;
        } else {
            // 让程序继续往下访问用户的目标资源
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        System.out.println("销毁方法");
    }
}
