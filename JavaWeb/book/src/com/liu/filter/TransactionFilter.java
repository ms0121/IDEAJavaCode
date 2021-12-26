package com.liu.filter;

import com.liu.utils.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author lms
 * @date 2021-04-09 - 16:01
 */
public class TransactionFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // filter操作会间接的调用servlet程序，
        try {
            filterChain.doFilter(servletRequest, servletResponse);
            // 提交事务
            JdbcUtils.commitAndClose();
        } catch (IOException e) {
            // 出现异常直接回滚事务的操作
            JdbcUtils.rollbackAndClose();
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {

    }
}
