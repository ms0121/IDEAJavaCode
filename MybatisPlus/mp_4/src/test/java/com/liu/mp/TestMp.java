package com.liu.mp;

import com.baomidou.mybatisplus.plugins.Page;
import com.liu.mp.beans.Employee;
import com.liu.mp.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author lms
 * @date 2021-05-05 - 21:19
 *  插件的使用
 */
public class TestMp {
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    // 获取接口的代理对象(使用的spring的ioc方法)
    public EmployeeMapper getEmp(){
        EmployeeMapper employeeMapper = context.getBean("employeeMapper", EmployeeMapper.class);
        return employeeMapper;
    }

//    4.乐观锁的设置
    @Test
    public void test5() {
        EmployeeMapper employeeMapper = getEmp();
        Employee employee = new Employee();
        employee.setId(19);
        employee.setLastName("陈浩南");
        employee.setEmail("chenhaonan@163.com");
        employee.setAge(18);
        employee.setVersion(3);

        Integer flag = employeeMapper.updateById(employee);
        System.out.println("flag = " + flag);
    }



//    3.sql插入性能分析插件
    @Test
    public void test4() {
        EmployeeMapper employeeMapper = getEmp();
        Employee employee = new Employee();
        employee.setLastName("大小姐");
        employee.setEmail("daxiaojie@qq.com");
        employee.setGender("1");
        employee.setAge(18);
        employeeMapper.insert(employee);

    }


//    2.禁止删除全表的插件应用
    @Test
    public void test3() {
        EmployeeMapper employeeMapper = getEmp();
        // 删除整个表的数据信息
        Integer flag = employeeMapper.delete(null);
        System.out.println("flag = " + flag);
    }


//   1.分页插件的使用
    @Test
    public void test2() {
        Page<Employee> page = new Page<>(1,2);
        EmployeeMapper employeeMapper = getEmp();
        List<Employee> employees = employeeMapper.selectPage(page, null);
        System.out.println("employees = " + employees);

        System.out.println("=================执行分页的一些相关信息======================");
        System.out.println("总记录数: " + page.getTotal());
        System.out.println("每页的记录数: " + page.getSize());
        System.out.println("当前页: " + page.getCurrent());
        System.out.println("总页码: " + page.getPages());
        System.out.println("是否有上一页: " + page.hasPrevious());
        System.out.println("是否有下一页: " + page.hasNext());
        // 将查询的结果封装到page对象中
        page.setRecords(employees);

    }


    @Test
    public void test1() {
        Employee employee = new Employee();
        Page<Employee> page = employee.selectPage(new Page<Employee>(1, 1), null);
        System.out.println("page = " + page);

        System.out.println("当前的页数: " + page.getCurrent());
        System.out.println("page.getSize() = " + page.getSize());
        System.out.println("page.getTotal() = " + page.getTotal());
        List<Employee> employees = page.getRecords();
        for (Employee employee1 : employees) {
            System.out.println("employee1 = " + employee1);
        }
    }



}
