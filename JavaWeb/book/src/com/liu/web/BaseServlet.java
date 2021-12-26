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
        // 解决post请求中出现的中文乱码
        req.setCharacterEncoding("utf-8");
        // 解决响应出现的乱码
        resp.setContentType("text/html; charset=UTF-8");

        String action = req.getParameter("action");
        // 使用反射的方式
        // 通过action业务鉴别字符串，获取相应的业务方法并进行调用
        Method method = null;
        try {
            method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            // 调用该方法
            method.invoke(this, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            // 捕获异常必须往外抛出
            throw new RuntimeException(e);
        }

        // 以前的做法
        //        if ("login".equals(action)) {
        //            login(req, resp);
        //        } else if("regist".equals(action)){
        //            regist(req, resp);
        //        }

    }
}
