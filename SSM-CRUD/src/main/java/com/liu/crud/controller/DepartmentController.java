package com.liu.crud.controller;

import com.liu.crud.bean.Department;
import com.liu.crud.bean.Msg;
import com.liu.crud.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author lms
 * @date 2021-05-02 - 16:01
 */

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    // 返回员工数据信息
    @RequestMapping("/depts")
    @ResponseBody
    public Msg getDepts(){
        List<Department> departments = departmentService.getDepartments();
        return Msg.success().add("depts",departments);
    }
}
