package com.liu.spring2.service;

import com.liu.spring2.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lms
 * @date 2021-04-11 - 14:09
 */

// 下面这句话等价于基于xml的方式，即:<bean id="userService" class="com.liu.spring.service.UserService">
//  在注解里面，value的值可以省略不写，默认是等于类名称，但是首字母需要小写

//@Service(value = "userService")
@Service
public class UserService {

    // 根据属性的类型进行自动装填,使用了autowired注解的方式可以进行代替
    // 创建一个set方法:  public void setUserDao(UserDao userDao)
    // autowired可以直接设置属性值

//    autowired的方式
//    @Autowired
//    private UserDao userDao;

    // 指定用哪个具体的实现类进行装填，比如UserDao接口有多个实现类(UserDaoImpl, UserDaoImpl1， UserDaoImpl2，....)
    // 如果不注明，默认使用第一个UserDaoImpl今天填装注解
//    @Autowired
//    @Qualifier(value = "userDaoImpl")  // 根据名称进行注入，具体要跟autowired结合一起使用
//    private UserDao userDao;

//    @Resource    // 表示按照类型的方式进行注入
    @Resource(name = "userDaoImpl")  // 按照名称的方式进行注入
    private UserDao userDao;

    // 注入普通类型属性,其实注入就是常用的 set 方法,给属性(变量进行赋值)
    @Value(value = "山鸡是如何炼成的")
    private String name;


//    public void say(){
//        System.out.println("userDao = " + userDao);
//    }

    public void add() {
        System.out.println("service add..........");
        userDao.show();
        System.out.println("name = " + name);
    }

}








