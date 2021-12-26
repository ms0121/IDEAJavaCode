package com.liu.crm.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lms
 * @date 2021-05-10 - 20:55
 */
public class StudentServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servletPath = request.getServletPath();
        if ("/student/save.do".equals(servletPath)){
            save(request, response);
        }else if ("/student/delete.do".equals(servletPath)){
            delete(request, response);
        }else if ("/student/update.do".equals(servletPath)){
            update(request, response);
        }else if ("/student/select.do".equals(servletPath)){
            select(request, response);
        }

    }

    private void select(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("select 方法执行了...........");
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("update 方法执行了...........");
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("delete 方法执行了...........");
    }

    private void save(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("save 方法执行了...........");
    }
}
