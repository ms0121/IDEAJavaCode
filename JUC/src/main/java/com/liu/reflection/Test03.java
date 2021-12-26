package com.liu.reflection;

/**
 * @author lms
 * @date 2021-09-08 - 11:01
 */
public class Test03 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 获取系统类的加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        // 获取系统类加载器的父类加载器 --》 拓展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        // 获取拓展类加载器的父类加载器 --> 根加载器(c / c++)
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        // 测试当前类是哪个加载器加载的
        ClassLoader classLoader =
                Class.forName("com.liu.reflection.Test03").getClassLoader();
        System.out.println(classLoader);

        // 测试jdk内置的类是谁加载的
        ClassLoader classLoader1 = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader1);

    }
}
