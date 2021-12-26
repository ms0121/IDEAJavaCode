package com.liu.boot.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.liu.boot.service.StudentService;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lms
 * @date 2021-05-23 - 21:19
 */

@Controller
public class StudentController {

    // <dubbo:reference interface .............
    @Reference(interfaceClass = StudentService.class)
    private StudentService studentService;

    @RequestMapping("/student/count")
    @ResponseBody
    public Object StudentCount(){
        Integer count = studentService.queryAllStudentCount();
        return "学生总数是： " + count;
    }

}
