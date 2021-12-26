package com.liu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lms
 * @date 2021-04-23 - 13:21
 */
public class AjaxServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
//        String name = req.getParameter("name");
//        String height = req.getParameter("height");
//        String weight = req.getParameter("weight");
//
//        float h =  Float.valueOf(height);
//        float w = Float.valueOf(weight);
//
//        float  mbi = w / (h * h);
//
//        String msg = "";
//
//        if (mbi > 18.5){
//            msg = "过重了";
//        }else if (mbi < 15.3){
//            msg = "过瘦了";
//        }else {
//            msg = "身材很好";
//        }
//        String str = name + "你的mbi是: " + mbi + "，属于：" + msg;
        System.out.println("该方法执行了------------------");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
    }
}
