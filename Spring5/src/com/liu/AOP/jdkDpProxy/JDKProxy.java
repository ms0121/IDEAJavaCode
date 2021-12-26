package com.liu.AOP.jdkDpProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author lms
 * @date 2021-04-11 - 19:57
 */
public class JDKProxy {
    public static void main(String[] args) {

//        方法有三个参数：
//        第一参数，类加载器
//        第二参数，增强方法所在的类，这个类实现的接口，支持多个接口
//        第三参数，实现这个接口 InvocationHandler，创建代理对象，写增强的部分

        // 增强方法所在类的接口，可以支持多个接口
        Class[] interfaces = {UserDao.class};
        UserDaoImpl userDao = new UserDaoImpl();
        UserDao dao = (UserDao) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDaoProxy(userDao));
        int add = dao.add(2,5);
        System.out.println("add = " + add);
    }
}

// 创建代理对象代码
class UserDaoProxy implements InvocationHandler {
    // 创建谁的代理对象，就把谁传递过来(更了通用性，直接使用基类),并要实现其有参构造方法
    private Object obj;

    public UserDaoProxy(Object obj) {
        this.obj = obj;
    }

    // 将要在UserDao增加的方法写在这里，即要增强的逻辑
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 需要增加的功能
        System.out.println("方法之前执行" + method.getName() + " : 传递的参数 ..." + Arrays.toString(args));
        // 执行被增强的方法（即原来的方法）
        Object res = method.invoke(obj, args);
        // 需要增加的方法
        System.out.println("方法执行之后......" + obj);
        return res;
    }
}



