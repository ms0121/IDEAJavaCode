package com.liu.model.aopProxy.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lms
 * @date 2021-10-06 - 21:57
 */
public class JdkProxy implements InvocationHandler {

    // 需要被代理的对象
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    // 通过Proxy类获取到代理类对象
    public Object getInstance(){
        /**
         * 参数1：类加载器
         * 参数2：被代理类的父类接口
         * 参数3：InvocationHandler类型的调用处理函数
         */
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("正在努力的找房子..........");
        Object result = method.invoke(target, args);
        System.out.println("签合同..........");
        return null;
    }
}
