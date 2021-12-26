package com.liu.reflection.reflection;

/**
 * @author lms
 * @date 2021-10-29 - 22:15
 * 各种获取Class对象的方法
 */
public class Test02 {
    public static void main(String[] args) throws ClassNotFoundException {

        User user = new User();

        // 方法1：
        Class<? extends User> aClass = user.getClass();
        System.out.println("aClass = " + aClass);

        // 方法2
        Class<User> userClass = User.class;
        System.out.println("userClass = " + userClass);

        // 方法3
        Class<?> aClass1 = Class.forName("com.liu.reflection.reflection.User");
        System.out.println("aClass1 = " + aClass1);

    }
}
