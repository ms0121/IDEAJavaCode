package com.liu.Servlet;

import com.sun.deploy.net.URLEncoder;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author lms
 * @date 2021-04-03 - 22:50
 */
public class Download extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取要下载的文件名
        String downLoadFilePath = "2.jpg";
        // 2.读取要下载的文件内容(通过ServletContext对象可以读取)
        ServletContext servletContext = getServletContext();
        // 获取要下载的文件类型
        String mimeType = servletContext.getMimeType("/img/" + downLoadFilePath);
        System.out.println("下载的文件类型是: " + mimeType);
        // 4.在回传前，通过相应头高速客户端返回的数据类型
        resp.setContentType(mimeType);

        // 5.还要告诉客户端收到的数据是用于下载使用(还是使用响应头)
        // Content-Disposition 相应头，表示收到的数据怎么处理
        // attachment 表示附件，表示下载使用
        // filename= 表示指定下载的文件名(其实就是将下载的文件进行重命名，downloadFilePath就是名字)
        // 也可以使用中文进行重命名，但是需要使用url编码的方式，并设定编码的方式
        // resp.setHeader("Content-Disposition", "attachment; filename=" + downLoadFilePath);
        resp.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode("风景.jps","utf-8"));
        //    / 斜杠被服务器解析表示地址为 http://ip:prot/工程名/ 映射 到代码的 Web 目录
        InputStream resourceAsStream = servletContext.getResourceAsStream("/img/" + downLoadFilePath);
        // 获取响应的输出流
        ServletOutputStream outputStream = resp.getOutputStream();
        // 3. 把下载的文件内容回传到客户端
        // 读取输入流中全部的数据，复制给输出流，输出给客户端
        IOUtils.copy(resourceAsStream, outputStream);
    }
}











