package com.liu.model.aopProxy.aop;

/**
 * @author lms
 * @date 2021-10-06 - 21:56
 */
public class Student implements Rent{

    @Override
    public void rent() {
        System.out.println("张三想要出去租房住........");
    }
}
