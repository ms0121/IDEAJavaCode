package com.liu.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liu.dao.QueryDao;
import com.liu.entity.City;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author lms
 * @date 2021-04-24 - 22:33
 */
public class QueryCity extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = "{}";
        String pid = req.getParameter("proId");
        QueryDao queryDao = new QueryDao();
        List<City> cities = queryDao.SelectCity(Integer.parseInt(pid));
        if (cities != null){
            // 将list转为JsonArray
            ObjectMapper objectMapper = new ObjectMapper();
            json = objectMapper.writeValueAsString(cities);
        }
        // 设置输出的内容是json，并设置编码方式是utf-8
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        // 将json数据相应回到到浏览器上
        writer.println(json);
        writer.flush();
        writer.close();
    }
}
