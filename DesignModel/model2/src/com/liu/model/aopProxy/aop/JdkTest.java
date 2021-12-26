package com.liu.model.aopProxy.aop;

/**
 * @author lms
 * @date 2021-10-06 - 22:03
 */
public class JdkTest {
    public static void main(String[] args) {
        // 被代理对象
        Student student = new Student();
        // 获取对象
        JdkProxy jdkProxy = new JdkProxy();
        // 注入被代理的对象
        jdkProxy.setTarget(student);
        // 获取代理对象
        // 这里必须要求使用的是父类的引用指向子类的对象
        Rent instance = (Rent) jdkProxy.getInstance();
        instance.rent();
    }
}
