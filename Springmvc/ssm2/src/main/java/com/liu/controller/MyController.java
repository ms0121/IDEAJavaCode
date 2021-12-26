package com.liu.controller;

import com.liu.domain.Student;
import com.liu.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lms
 * @date 2021-04-18 - 13:37
 */

@Controller
@RequestMapping("/student")
public class MyController {

    @Resource // 自动注入创建对象
    private StudentService studentService;

    @RequestMapping("/addStudent.do")
    public ModelAndView addStudent(Student student) {
        ModelAndView mv = new ModelAndView();
        String tips = "注册失败";
        int flag = studentService.addStudent(student);
        if (flag > 0){
            tips = "学生 【" + student.getName() + "】 注册成功";
        }
        // 将结果数据进行保存
        mv.addObject("tips", tips);
        // 请求转发到result页面
        mv.setViewName("result");
        return mv;
    }

    @RequestMapping("/listStudent.do")
    @ResponseBody  // 必须添加
    public List<Student> name() {
        List<Student> students = studentService.listStudent();
        return students; // 查询得到的数据将会被转为json的数组形式
    }

}
