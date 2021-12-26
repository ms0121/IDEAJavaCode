package com.liu.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @author lms
 * @date 2021-09-25 - 22:36
 */
@Controller
public class UploadFileController {

    /**
     * 执行上传文件的操作
     * @param request 请求域
     * @param file 上传的文件
     * @return
     */
    @RequestMapping("uploadFile")
    public String upload(HttpServletRequest request, @RequestParam("file") MultipartFile file){
        // 判断上传的文件是否为空，如果不为空则进行对应的文件上传操作
        if (!file.isEmpty()){
            try {
                // 获取项目所在的路径
                String realPath = request.getServletContext().getRealPath("/");
                System.out.println("realPath = " + realPath);
                // 设置上传文件存放的目录
                File uploadFile = new File(realPath + "/upload");
                // 判断存放文件的目录是否存在，不存在则进行创建
                if (!uploadFile.exists()){
                    // 创建文件目录
                    uploadFile.mkdir();
                }

                // 获取上传的文件名
                String originalFilename = file.getOriginalFilename();
                // 文件上传
                file.transferTo(new File(uploadFile, originalFilename));
                request.setAttribute("msg", "文件上传成功!");

            } catch (IOException e) {
                e.printStackTrace();
                request.setAttribute("msg", "文件上传失败!");
            }
        } else {
            request.setAttribute("msg", "文件不存在!");
        }
        return "result";
    }


}
