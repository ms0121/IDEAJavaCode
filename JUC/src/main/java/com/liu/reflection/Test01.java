package com.liu.reflection;

/**
 * @author lms
 * @date 2021-09-08 - 9:40
 */
// 什么叫做反射？
public class Test01 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 一个类在内存中只有一个Class对象
        // 通过反射可以获取类的class对象
        Class<?> c1 = Class.forName("com.liu.reflection.User");
        System.out.println("c1 = " + c1);

        // 获取当前实例对象(类)的父类
        Class<?> c5 = c1.getSuperclass();
        System.out.println("c5 = " + c5);

        // 一个类被加载之后，类的整个结构都会被封装在class对象中
        Class<?> c2 = Class.forName("com.liu.reflection.User");
        Class<?> c3 = Class.forName("com.liu.reflection.User");
        Class<?> c4 = Class.forName("com.liu.reflection.User");

        System.out.println("c2.hashCode() = " + c2.hashCode());
        System.out.println("c3.hashCode() = " + c3.hashCode());
        System.out.println("c4.hashCode() = " + c4.hashCode());
    }
}




