package com.liu.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liu.dao.ProvinceDao;
import com.liu.entity.Province;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author lms
 * @date 2021-04-23 - 19:44
 */
public class QueryJsonServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 默认就是一个json的变量
        String json = "{}";
        String proid = req.getParameter("proid");

        // 大于0说明有值
        if (proid != null && proid.trim().length() > 0){
            ProvinceDao provinceDao = new ProvinceDao();
            Province province = provinceDao.queryProById(Integer.valueOf(proid));
            // 将获取得到的Province对象封装成为json数据的字符串形式
            ObjectMapper objectMapper = new ObjectMapper();
            json = objectMapper.writeValueAsString(province);
        }
        // 把获取到的数据通过网络传给ajax中的异步对象，响应结果数据
        // 指定服务器端(servlet)返回给浏览器的是json格式的数据信息
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        // 输出数据，-- 会赋给ajax中的responseText属性
        writer.println(json);
        writer.flush();
        writer.close();
    }
}
