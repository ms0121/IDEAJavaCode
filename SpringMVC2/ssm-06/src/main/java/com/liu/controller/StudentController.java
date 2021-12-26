package com.liu.controller;

import com.liu.domain.Student;
import com.liu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author lms
 * @date 2021-04-29 - 10:58
 */

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // 处理添加学生的请求页面
    @RequestMapping("/addStudent.do")
    public ModelAndView addStudent(Student student) {
        String tips = "注册失败";
        ModelAndView mv = new ModelAndView();
        int flag = studentService.addStudent(student);
        if (flag > 0){
            tips = "祝贺你【" + student.getName() + "】注册成功!";
        }
        mv.addObject("tips", tips);
        mv.setViewName("result");
        return mv;
    }


    // 处理请求，响应ajax
    @RequestMapping("/queryStudent.do")
    @ResponseBody
    public List<Student> queryStudent() {
        List<Student> students = studentService.findStudents();
        return students;
    }
}
