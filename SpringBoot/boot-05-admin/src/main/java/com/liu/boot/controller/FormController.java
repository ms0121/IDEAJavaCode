package com.liu.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author lms
 * @date 2021-05-18 - 20:25
 * 文件上传的方式
 */
@Controller
public class FormController {

    @GetMapping("/form_layouts")
    public String form_layout(){
        return "form/form_layouts";
    }

    // 处理文件上传的请求，@RequestParam("email")标识当前的参数来源于请求中的参数值
    // MultipartFile 文件封装的对象，@RequestPart 来源于请求的文件对象
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImg") MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {
        System.out.println("email = " + email);
        System.out.println("username = " + username);

        // sprigboot封装的对于上传的文件的判断
        if (!headerImg.isEmpty()){
            // 保存到本地,将文件传输到指定的路径
            // 获取原文件名
            String originalFilename = headerImg.getOriginalFilename();
            headerImg.transferTo(new File("D:\\Filetest\\" + originalFilename));

        }

        if (photos.length > 0){
            for (MultipartFile photo : photos) {
                if (!photo.isEmpty()){
                    String originalFilename = photo.getOriginalFilename();
                    photo.transferTo(new File("D:\\Filetest\\cache\\" + originalFilename));
                }
            }
        }
        // 返回首页
        return "main";
    }

}
