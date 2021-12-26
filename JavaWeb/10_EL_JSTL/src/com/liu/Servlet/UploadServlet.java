package com.liu.Servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author lms
 * @date 2021-04-03 - 14:53
 */
public class UploadServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // System.out.println("文件上传过来了!");
        // 1.先判断上传的数据是否是多段数据（只有是多段数据，才是文件上传的）
        if (ServletFileUpload.isMultipartContent(req)){
            // 然后创建FileItemFactory工厂实现类
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            // 创建用于解析上传数据的工具类ServletFileUpload类
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            try {
                // 解析用于上传的数据，得到每一个表单项的FileItem
                List<FileItem> list = servletFileUpload.parseRequest(req);
                // 循环判断每个表单项，是普通类型还是上传的文件
                for (FileItem fileItem: list) {
                    if (fileItem.isFormField()){
                        // 返回真表示是普通表单项
                        System.out.println("表单项的name属性值: fileItem.getName() = " + fileItem.getFieldName());
                        // 设置value值的编码方式，解决乱码的问题
                        System.out.println("表单项的value属性值: fileItem.getString() = " + fileItem.getString("utf-8"));
                    }else {
                        // 返回false说明上传的是文件类型
                        System.out.println("表党项的name属性值: fileItem.getFieldName() = " + fileItem.getFieldName());
                        System.out.println("上传的文件名: fileItem.getName() = " + fileItem.getName());
                        try {
                            fileItem.write(new File("D:\\" + fileItem.getName()));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            }

        }
    }
}
















