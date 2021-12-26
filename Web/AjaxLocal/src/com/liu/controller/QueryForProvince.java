package com.liu.controller;

import com.liu.dao.ProvinceDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author lms
 * @date 2021-04-23 - 17:33
 */
public class QueryForProvince extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("请求执行了-----------");
        String proid = req.getParameter("proid");

        String name = "默认无数据";
        if (proid != null && !"".equals(proid.trim())){
            ProvinceDao provinceDao = new ProvinceDao();
            name = provinceDao.queryPrivinceById(Integer.valueOf(proid));
        }
        // 使用过HttpServletResponse输出数据
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        // 将数据输出到浏览器
        pw.println(name);
//        pw.println("北京");
        pw.flush();
        pw.close();
    }
}









