package com.liu.aop.jdk;

import com.liu.aop.demo1.RentHouse;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lms
 * @date 2021-10-03 - 21:22
 * 代理类，不像静态代理中的代理类是一个固定的只能代理一个需要的代理类
 *
 */
//调用该方法会自动生成代理类
public class ProxyInvocationHandler implements InvocationHandler {

    // 被代理的类
    private RentHouse rentHouse;

    public void setRentHouse(RentHouse rentHouse) {
        this.rentHouse = rentHouse;
    }

    // 得到代理类
    public Object getProxy(){
        /**
         * 参数1：类加载器，来定义需要被代理的类
         * 参数2：代理类需要实现被代理类的接口列表
         * 参数3：调度方法调用的调用处理函数(也就是InvocationHandler接口的实现类)
         */
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                rentHouse.getClass().getInterfaces(),
                this);
    }

    // 执行被代理类中的方法，并返回结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log();

        // 下面语句个人理解：rentHouse通过调用invoke(执行)接口中的method方法，并传递参数集args
        // 动态代理的本质：就是使用反射的机制实现
        Object result = method.invoke(rentHouse, args);

        log();
        return result;
    }

    // 打印日志
    public void log(){
        System.out.println("====[debug]====");
    }
}
