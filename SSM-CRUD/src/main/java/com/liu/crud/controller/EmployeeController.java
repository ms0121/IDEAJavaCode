package com.liu.crud.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liu.crud.bean.Employee;
import com.liu.crud.bean.Msg;
import com.liu.crud.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author lms
 * @date 2021-05-01 - 16:00
 */

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    // 删除指定的员工
    @RequestMapping(value = "/emp/{ids}", method = RequestMethod.DELETE)
    @ResponseBody
    public Msg updateEmp(@PathVariable("ids") String ids) {
        if (ids.contains("-")){
            List<Integer> list = new ArrayList<>();
            String[] split = ids.split("-");
            for (String s : split) {
                list.add(Integer.parseInt(s));
            }
            employeeService.deleteEmpBatch(list);
        }else {
            int id = Integer.parseInt(ids);
            employeeService.deleteEmp(id);
        }
        return Msg.success();
    }



    // 保存修改后的信息
    @RequestMapping(value = "/emp/{empId}", method = RequestMethod.PUT)
    @ResponseBody
    public Msg updateEmp(Employee employee) {
        employeeService.updateEmp(employee);
        return Msg.success();
    }


    // 根据员工的id获取员工的信息
    @RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Msg getEmployee(@PathVariable("id") Integer id){
        Employee employee = employeeService.getEmployee(id);
        return Msg.success().add("emp", employee);
    }

    // 验证当前输入的用户名是否可用
    // 使用的参数是请求携带的empName
    @RequestMapping("/checkuser")
    @ResponseBody
    public Msg checkuser(@RequestParam("empName") String empName) {
        // 1.先判断当前的用户名是否可用
        String regx = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\\u2E80-\\u9FFF]{2,5})";
        if (!empName.matches(regx)){
            return Msg.fail().add("va_msg","用户名格式不合法");
        }
        Boolean flag = employeeService.checkUser(empName);
        if (flag){
            return Msg.success();
        }else {
            return Msg.fail().add("va_msg","用户名不可用");
        }
    }


    // 保存员工数据信息
    // 表示对要保存的员工信息进行验证
    @RequestMapping(value = "/emps", method = RequestMethod.POST)
    @ResponseBody
    public Msg saveEmp(@Valid Employee employee, BindingResult result){
        if (result.hasErrors()){
            // 校验要保存的员工信息,如果有错误，直接在模态框进行显示
            HashMap<String, Object> map = new HashMap<>();
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError fieldError : errors) {
                System.out.println("错误的字段名: " + fieldError.getField());
                System.out.println("错误的信息: " + fieldError.getDefaultMessage());
                map.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return Msg.fail().add("errorFields", map);
        }else {
            employeeService.saveEmployee(employee);
            return Msg.success();
        }
    }



    // 使用ajax方式，返回json格式的数据
    @RequestMapping("/emps")
    @ResponseBody  // 将数据转为json进行返回
    public Msg getEmps(@RequestParam(value = "pn", defaultValue = "1") Integer pn){
        PageHelper.startPage(pn, 5);
        List<Employee> emps = employeeService.getAll();
        PageInfo pages = new PageInfo(emps, 5);
        // Msg.success() 获取一个Msg对象，再给该对象的extend集合进行赋值
        return Msg.success().add("pageInfo", pages);
    }



    // 这种进行转发的方式并不太好，不能支持多平台的方式，所以推荐使用ajax的请求的方式，将其返回的数据封装在json中
    // 使用的是地址传过来的pn值，默认使用的是第一页
    // 将封装好的数据信息通过model传到页面上
//    @RequestMapping("/emps")
    public String getEmps(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
                          Model model) {
        // 获取员工信息，并使用分页查询的方式进行封装
        // 在查询之前只需要调用即可，参数表示查询页码，以及每一页的数量
        PageHelper.startPage(pn, 5);
        // startPage后面紧跟的这个查询结果就是一个分页查询
        List<Employee> emps = employeeService.getAll();
        // 使用pageInfo包装查询后得到的结果，然后只需要将封装好的数据交给页面即可
        // 封装了详细的分页信息，包括有我们查询出来的数据，传入连续显示的页面
        PageInfo pageInfo = new PageInfo(emps, 5);
        model.addAttribute("pageInfo", pageInfo);

        // 跳转到员工显示列表
        return "list";
    }
}
