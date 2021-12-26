package com.liu.fileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

/**
 * @author lms
 * @date 2021-09-24 - 22:40
 */
@WebServlet("/uploadFile")
// 如果是文件上传，必须要设置该注解，否则文件上传失败
// 因为是文件上传表单，所以必须使用该注解，否则无法获取到表单中的属性值
@MultipartConfig
public class UploadFile extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("文件上传..........");
        // 设置请求域的编码格式
        request.setCharacterEncoding("utf-8");

        // 获取文件上传表单中的数据信息
        String name = request.getParameter("name");
        System.out.println("name = " + name);

        // 上传的文件存放在Part对象中(因为servlet将multipart/form-data的post请求封装为Part对象)
        Part file = request.getPart("file");
        // 获取提交的文件的名字
        String submittedFileName = file.getSubmittedFileName();
        System.out.println("上传的文件名： " + submittedFileName);

        // 设置输出的文件路径信息
        String path = "C:/Users/Administrator/Desktop";
        // 上传文件到指定的目录
        file.write(path + "/720/" + submittedFileName);
    }
}
