package com.liu.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 父类
 * @author lms
 * @date 2021-04-04 - 11:44
 */
public abstract class BaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // a标签的点击为get请求，所以需要设置doGet请求的功能
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 解决请求中的乱码问题
        req.setCharacterEncoding("utf-8");
        // 解决响应中的乱码问题
        resp.setContentType("text/html; charset=UTF-8");

        String action = req.getParameter("action");
        // 使用反射的方式
        // 通过action业务鉴别字符串，获取相应的业务方法并进行调用
        Method method = null;
        try {
            method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            // 调用该方法,
            try {
                method.invoke(this, req, resp);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } finally {

        }

        // 以前的做法
        //        if ("login".equals(action)) {
        //            login(req, resp);
        //        } else if("regist".equals(action)){
        //            regist(req, resp);
        //        }

    }
}
