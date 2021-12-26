package com.liu.model.aopProxy.statisProxy;

/**
 * @author lms
 * @date 2021-10-06 - 21:24
 */
public class Person implements Rent{

    @Override
    public void rentHouse() {
        System.out.println("张三需要租房子，预算是2k..............");
    }
}
