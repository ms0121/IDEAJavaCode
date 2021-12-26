package com.liu.aop.cglib;

/**
 * @author lms
 * @date 2021-10-04 - 9:24
 */
public class Starter {
    public static void main(String[] args) {
        Student student = new Student();
        // 创建代理类
        CglibInterceptor cglibInterceptor = new CglibInterceptor();
        cglibInterceptor.setTarget(student);
        // 获取代理类对象
        Student proxy = (Student) cglibInterceptor.getProxy();
        // 调用目标类方法
        proxy.study();
    }
}
