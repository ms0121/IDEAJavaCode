package com.liu.controller;

import com.liu.domain.Student;
import com.liu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lms
 * @date 2021-04-18 - 0:00
 */

@Controller
@RequestMapping("/student")
public class StudentController {


    @Resource // 自动注入创建对象
    private StudentService studentService;

    @RequestMapping("/addStudent.do")
    public ModelAndView addStudent(Student student) {
        ModelAndView mv = new ModelAndView();
        String tips = "注册失败";
        int flag = studentService.insertStudent(student);
        if (flag > 0){
            tips = "学生 【" + student.getName() + "】 注册成功";
        }
        // 将结果数据进行保存
        mv.addObject("tips", tips);
        // 请求转发到result页面
        mv.setViewName("result");
        return mv;
    }

    // 处理查询，相应ajax，需要将数据转为json，有3个步骤：
        //  1. 检查pom.xml依赖项目中有没有Jackson依赖
        //  2. springmvc的配置文件(dispatcherServlet.xml)中需要加上注解驱动 <mvc:annotation-driven/>
        //  3. 在controller方法上面加上注解 @ResponseBody
    @RequestMapping("/queryStudent.do")
    @ResponseBody  // 必须添加
    public List<Student> name() {
        List<Student> students = studentService.findStudents();
        return students; // 查询得到的数据将会被转为json的数组形式
    }

}








