package com.liu.aop.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author lms
 * @date 2021-10-04 - 9:20
 */
public class CglibInterceptor implements MethodInterceptor {

    // 目标类
    private Object target;

    // set注入目标类(需要被代理的类)
    public void setTarget(Object target) {
        this.target = target;
    }

    // 获取代理对象
    public Object getProxy() {
        // 通过Enhance对象的create()方法可以生成一个类，用于生成代理对象
        Enhancer enhancer = new Enhancer();
        // 设置父类(将目标类作为代理类的父类)
        enhancer.setSuperclass(target.getClass());
        // 设置拦截器，回调对象为本身对象（因为该对象已经实现了MethodInterceptor接口）
        enhancer.setCallback(this);
        // 生成一个代理类对象并返回
        return enhancer.create();
    }

    /**
     * 拦截器：
     * 1. 目标对象的方法调用
     * 2. 增强行为
     *
     * @param o           由CGLIB动态生成的代理类实例
     * @param method      实体类所调用的被代理的方法引用（也就是student中的study()方法，
     *                    即调用哪个方法就是哪个）
     * @param objects     调用方法的参数值
     * @param methodProxy 生成的代理类对方法的代理引用
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        // 返回代理对象调用的方法
        // String result = method.getName();

        // 额外功能的增强
        System.out.println("先做到每天早起..........");

        // 执行目标对象中的方法，并传递目标方法的形参
        Object result = method.invoke(target, objects);

        // 额外的功能增强
        System.out.println("记得每天按时吃饭，锻炼，复习.........");

        return result;
    }
}
