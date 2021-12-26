package com.liu.aop.demo1;

/**
 * @author lms
 * @date 2021-10-03 - 18:12
 */
public class Person implements RentHouse {
    @Override
    public void rent() {
        System.out.println("张三想要租房子,预算1000..........");
    }
}
