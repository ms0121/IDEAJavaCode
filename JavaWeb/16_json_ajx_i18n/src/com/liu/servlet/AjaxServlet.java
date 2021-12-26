package com.liu.servlet;

import com.google.gson.Gson;
import com.liu.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lms
 * @date 2021-04-10 - 10:17
 */
public class AjaxServlet extends BaseServlet {

    protected void jsAjax(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ajax请求进来了");
        Person person = new Person(1, "zhansgan", 20);
        Gson gson = new Gson();
        String s = gson.toJson(person);
        // 返回相应字符输出流
        response.getWriter().write(s);
    }

    protected void jQueryAjax(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("在jQuery中使用ajax");
        Person person = new Person(1, "zhansgan", 20);
        Gson gson = new Gson();
        String s = gson.toJson(person);
        // 返回相应字符输出流
        response.getWriter().write(s);
    }

    protected void jQueryGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("jQueryGet被调用了");
        Person person = new Person(1, "zhansgan", 20);
        Gson gson = new Gson();
        String s = gson.toJson(person);
        // 返回相应字符输出流
        response.getWriter().write(s);
    }

    protected void jQueryPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("jQueryPost被调用了");
        Person person = new Person(1, "zhansgan", 20);
        Gson gson = new Gson();
        String s = gson.toJson(person);
        // 返回相应字符输出流
        response.getWriter().write(s);
    }

    protected void jQueryGetJson(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("jQueryGetJson被调用了");
        Person person = new Person(1, "zhansgan", 20);
        Gson gson = new Gson();
        String s = gson.toJson(person);
        // 返回相应字符输出流
        response.getWriter().write(s);
    }


    protected void jQuerySerialize(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("jQuerySerialize被调用了");
        Person person = new Person(1, "zhansgan", 20);
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        Gson gson = new Gson();
        String s = gson.toJson(person);
        // 返回相应字符输出流
        response.getWriter().write(s);
    }
}
