package com.liu.model.aopProxy.statisProxy;

/**
 * @author lms
 * @date 2021-10-06 - 21:26
 */
public class Test {
    public static void main(String[] args) {
        // 被代理的对象是谁
        Person person = new Person();
        RentAgency agency = new RentAgency();
        // 进行属性的注入（表明具体给哪个用户进行代理）
        agency.setTarget(person);
        agency.rentHouse();

    }
}
