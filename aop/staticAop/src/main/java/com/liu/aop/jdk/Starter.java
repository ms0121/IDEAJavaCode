package com.liu.aop.jdk;

import com.liu.aop.demo2.UserService;
import com.liu.aop.demo2.UserserviceImpl;

/**
 * @author lms
 * @date 2021-10-03 - 21:16
 */
public class Starter {
    public static void main(String[] args) {
//        // 被代理类
//        RentHouse person = new Person();
//
//        ProxyInvocationHandler handler = new ProxyInvocationHandler();
//        // 设置handler中的被代理类的属性值
//        handler.setRentHouse(person);
//        // 通过反射的方式获取代理类
//        RentHouse proxy = (RentHouse) handler.getProxy();
//        // 通过代理类执行被代理的方法
//        proxy.rent();

        // 针对userService
        UserService userservice = new UserserviceImpl();
        // 获取代理类
        ProxyInvocationHandlerPlus handlerPlus = new ProxyInvocationHandlerPlus();
        handlerPlus.setTarget(userservice);
        // 获取代理对象
        UserService proxy = (UserService) handlerPlus.getProxy();
        proxy.query();
    }
}
