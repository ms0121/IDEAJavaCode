package com.liu.boot.controller;

import com.liu.boot.dao.DepartmentDao;
import com.liu.boot.dao.EmployeeDao;
import com.liu.boot.pojo.Department;
import com.liu.boot.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author lms
 * @date 2021-05-12 - 9:13
 */

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String getEmps(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps", employees);
        return "emps/list";
    }

    @GetMapping("/emp")
    public String addEmp(Model model) {
        // 获取所有的部门信息
        Collection<Department> department = departmentDao.getDepartment();
        model.addAttribute("departments", department);
        return "emps/add";
    }

    @PostMapping("/emp")
    public String saveEmp(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    // 修改员工页面
    @GetMapping("/emp/{id}")
    public String update(@PathVariable("id") Integer id, Model model) {
        System.out.println("id = " + id);
        Employee employee = employeeDao.getEmployeeById(id);
        System.out.println("employee = " + employee);
        model.addAttribute("emp", employee);
        // 获取所有的部门信息
        Collection<Department> department = departmentDao.getDepartment();
        model.addAttribute("departments", department);
        return "emps/update";
    }

    // 保存修改的信息
    @PostMapping("/emp/{id}")
    public String updateEmp(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }


    // 删除员工信息
    @RequestMapping("/del/{id}")
    public String delete(@PathVariable("id") Integer id, Model model) {
        System.out.println("id = " + id);
        employeeDao.delete(id);
//        model.addAttribute("msg", "删除成功");
        return "redirect:/emps";
    }
}
