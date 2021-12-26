package com.liu.mp;

import com.liu.mp.beans.User;
import com.liu.mp.mapper.EmployeeMapper;
import com.liu.mp.mapper.UserMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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


    // 获取接口的代理对象(使用的spring的ioc方法)
    public UserMapper getUser(){
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        return userMapper;
    }


    @Test
    public void test1() {
        UserMapper userMapper = getUser();

//        删除指定id的员工信息
//        Integer flag = userMapper.deleteById(1);
//        System.out.println("flag = " + flag);

//        查询被删除的员工信息
        User user = userMapper.selectById(2);
        System.out.println("user = " + user);

    }
}













