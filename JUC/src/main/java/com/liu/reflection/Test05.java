package com.liu.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author lms
 * @date 2021-09-08 - 11:50
 *
 * setAccessible()作用是启动和禁用访问安全检查的开关
 * 参数值为true则指示反射的对象在使用是应该取消java语言访问检查，反之。
 */
public class Test05 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException,
            InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {

        // 获取Class类
        Class<?> cl = Class.forName("com.liu.reflection.User");

        // 创建一个实例对象，本质是调用了一个无参构造器
        User user = (User) cl.newInstance();
        System.out.println("user = " + user);
//        user.setAge(19);
//        System.out.println("user.getAge() = " + user.getAge());

        // 获取构造器（使用具体的有参构造器）
//        Constructor<?> constructor = cl.getDeclaredConstructor(String.class, int.class, int.class);
//        User user1 = (User) constructor.newInstance("张三", 19, 20);
//        System.out.println("user1 = " + user1);

        // 通过反射获取并设置属性
        Field name = cl.getDeclaredField("name");
        // 当前属性是private类型，所以必须关闭访问权限检测
        name.setAccessible(true);
        name.set(user, "李四");
        System.out.println("user = " + user);

        // 通过反射获取并调用方法
//        Method setName = cl.getDeclaredMethod("setName", String.class);
////        如果当前调用的方法是私有的，必须关闭权限检查
////        setName.setAccessible(true);
////      调用方法 invoke 激活的意思， invoke(对象，方法的参数值),意思是执行user中的serName方法，设置为 “张三丰”
//        setName.invoke(user, "张三丰");
//        System.out.println("user = " + user);
    }
}
