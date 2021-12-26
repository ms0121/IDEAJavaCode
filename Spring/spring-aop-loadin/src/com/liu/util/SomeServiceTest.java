package com.liu.util;

import com.liu.handler.MyInvocation;
import com.liu.service.Impl.SomeServiceImpl;
import com.liu.service.SomeService;
import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * @author lms
 * @date 2021-04-26 - 10:39
 */
public class SomeServiceTest {

    @Test
    public void test1() {
//        SomeService someService = new SomeServiceImpl();
//        someService.doSome();
//        someService.doOther();

        // 使用jdk动态代理的方式
        // 创建目标对象
        SomeServiceImpl target = new SomeServiceImpl();

        // 创建InvocationHandler对象
        MyInvocation handler = new MyInvocation(target);

        // 使用Proxy创建对象
        SomeService proxy = (SomeService) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                handler);

        // 通过代理执行方法，会调用handler中的invoke方法
        proxy.doSome();
        System.out.println("================");
        proxy.doOther();

    }
}
