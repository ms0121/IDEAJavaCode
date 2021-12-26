package com.liu.aop.demo1;

/**
 * @author lms
 * @date 2021-10-03 - 18:15
 */
public class Starter {
    public static void main(String[] args) {
        Person person = new Person();
        // 代理帮person这个人进行租房子
        Proxy proxy = new Proxy();
        proxy.setTarget(person);
        proxy.rent();
    }
}
