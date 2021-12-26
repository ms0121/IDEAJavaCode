package com.liu.cglibAop;

/**
 * @author lms
 * @date 2021-10-06 - 22:21
 */
public class CglibTest {
    public static void main(String[] args) {

        // 被代理的对象
        Person person = new Person();
        CglibProxy cglibProxy = new CglibProxy();
        cglibProxy.setTarget(person);
        Person instance = (Person) cglibProxy.getInstance();
        instance.study();
    }
}
