package com.liu.reflection.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * @author lms
 * @date 2021-10-29 - 21:56
 */
public class Test01 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Class<?> aClass = Class.forName("com.liu.reflection.reflection.User");
        System.out.println("aClass = " + aClass);
        Class<?> aClass1 = Class.forName("com.liu.reflection.reflection.User");
        /**
         * 说明了一个类只对应一个Class对象
         */
        System.out.println("aClass.equals(aClass1) = " + aClass.equals(aClass1));

        Method[] methods = aClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("method = " + method);
            Type[] parameterTypes = method.getGenericParameterTypes();
            Type returnType = method.getGenericReturnType();
            for (Type parameterType : parameterTypes) {
                System.out.println("parameterType = " + parameterType);
            }
            System.out.println("returnType = " + returnType);
        }

        System.out.println("========================");
        User user = new User();
        user.setName("李四");
        Method getName = aClass.getMethod("getName");
        Object obj = getName.invoke(user);
        System.out.println("obj = " + obj);

        System.out.println("========================");
        Method setAge = aClass.getMethod("setAge", Integer.class);
        // 给user对象设置age属性的值
        setAge.invoke(user, 20);
        System.out.println("user = " + user);

        System.out.println("========================");
        // 获取所有的方法，包括private受保护的方法
        Method say = aClass.getDeclaredMethod("say");
        // 对于private修饰的方法必须使用setAccessible设置为true，否则没有权限进行访问和调用方法
        say.setAccessible(true);
        say.invoke(user);
    }
}
