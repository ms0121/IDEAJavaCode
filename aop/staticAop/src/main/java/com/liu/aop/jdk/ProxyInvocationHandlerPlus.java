package com.liu.aop.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lms
 * @date 2021-10-03 - 21:22
 * 代理类，不像静态代理中的代理类是一个固定的只能代理一个需要的代理类
 */
//调用该方法会自动生成代理类
public class ProxyInvocationHandlerPlus implements InvocationHandler {

    // 被代理的类
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    // 得到代理类
    public Object getProxy() {
        /**
         * 参数1：类加载器，来定义需要被代理的类
         * 参数2：代理类需要实现被代理类的接口列表
         * 参数3：调度方法调用的调用处理函数(也就是InvocationHandler接口的实现类)
         */
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this);
    }

    // 执行被代理类中的方法，并返回执行的结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log();

        // 通过method可以获取到当前执行的方法名
        // String name = method.getName();

        // 下面语句个人理解：invoke(执行)target对象中的method(是一个具体的接口方法)方法
        // 动态代理的本质：就是使用反射的机制实现
        Object result = method.invoke(target, args);

        log();
        return result;
    }

    // 打印日志
    public void log() {
        System.out.println("====[debug]====");
    }
}
