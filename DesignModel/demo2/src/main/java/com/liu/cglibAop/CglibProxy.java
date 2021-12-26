package com.liu.cglibAop;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author lms
 * @date 2021-10-06 - 22:16
 *
 * cglib动态代理必须实现：MethodInterceptor接口，然后使用Enhancer创建代理类对象
 *
 */
public class CglibProxy implements MethodInterceptor {

    // 被代理的类
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    // 获取代理对象
    public Object getInstance(){
        Enhancer enhancer = new Enhancer();
        // 设置被代理的类为代理类的父类
        enhancer.setSuperclass(target.getClass());
        // 设置使用的拦截器
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("正在准备学习的资料..........");
        method.invoke(target, objects);
        System.out.println("正在收拾........");

        return null;
    }
}
