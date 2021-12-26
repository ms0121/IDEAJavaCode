package com.liu.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.FileHandler;

/**
 * @author lms
 * @date 2021-09-08 - 11:18
 */
public class Test04 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        // 获取Class类
        Class<?> c = Class.forName("com.liu.reflection.User");

        // 获取类的名字
        // 获得包名 + 类名
        System.out.println("c.getName() = " + c.getName());
        // 获得类名
        System.out.println("c.getSimpleName() = " + c.getSimpleName());


        // 获取类的属性
        // 只能获取public类型的属性
        Field[] fields1 = c.getFields();

        // 获取全部的属性
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("field = " + field);
        }

        // 获取执行属性的值
        Field name = c.getDeclaredField("name");
        System.out.println("name = " + name);

        // 获取类的方法
        // 只能获取当前类及其父类的public类型的方法
        Method[] methods = c.getMethods();

        // 获取当前类和父类的所有类型的方法
        Method[] methods1 = c.getDeclaredMethods();
        for (Method method : methods1) {
            System.out.println("method = " + method);
        }

        // 获取指定的方法
        Method getName = c.getMethod("getName", null);
        System.out.println("getName = " + getName);
        Method setName = c.getMethod("setName", String.class);
        System.out.println("setName = " + setName);

        // 获取构造器
        Constructor<?>[] constructors = c.getConstructors();
        Constructor<?>[] declaredConstructors = c.getDeclaredConstructors();
        Constructor<?> constructor = c.getDeclaredConstructor(String.class, int.class, int.class);
        System.out.println("constructor = " + constructor);


    }
}



