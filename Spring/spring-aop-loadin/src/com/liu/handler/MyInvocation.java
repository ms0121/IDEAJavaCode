package com.liu.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author lms
 * @date 2021-04-26 - 10:57
 */

// 动态代理实现功能的增加
public class MyInvocation implements InvocationHandler {

    // 实现代理的目标对象类（SomeServiceImpl类）
    private Object target;

    public MyInvocation(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("method = " + method);
        // 通过代理对象执行方法时，会调用执行这个invoke方法
        Object res = null;
        System.out.println("时间: " + new Date());

        // 执行目标类方法，通过Method类实现
        // target等于 SomeServiceImpl.doSome(), doOther()
        res = method.invoke(target, args);

        System.out.println("事务实现了");
        return res;
    }
}
