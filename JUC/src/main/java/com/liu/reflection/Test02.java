package com.liu.reflection;

/**
 * @author lms
 * @date 2021-09-08 - 10:03
 * 获取Class类的方式
 */
public class Test02 {
    public static void main(String[] args) throws ClassNotFoundException {

        User user = new User();
        // 方式1：获取当前对象的类
        Class<? extends User> c1 = user.getClass();
        System.out.println("c1 = " + c1);

        // 方式2：使用forName获取类
        Class<?> c2 = Class.forName("com.liu.reflection.User");
        System.out.println("c2 = " + c2);

        // 方式3：通过类名.class获取类
        Class<User> c3 = User.class;
        System.out.println("c3 = " + c3);

        // 方式4: 基本内置类型的包装类都有一个TYPE属性
        Class<Integer> c4 = Integer.TYPE;
        System.out.println("c4 = " + c4);

        // 方式5：获取当前类的父类
        Class<?> superclass = c1.getSuperclass();
        System.out.println("superclass = " + superclass);
    }
}
