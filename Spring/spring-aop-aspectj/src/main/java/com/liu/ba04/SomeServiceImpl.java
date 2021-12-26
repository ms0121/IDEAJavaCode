package com.liu.ba04;

/**
 * @author lms
 * @date 2021-04-26 - 16:02
 */

// 目标类
public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome(String name, int age) {
        System.out.println("========目标方法doSome执行了======");
    }

    @Override
    public String doOther(String name, int age) {
        System.out.println("doOther方法实现了");
        return "absnbs";
    }

    @Override
    public String doFirst(String name, int age) {
        System.out.println("===========doFirst方法被调用了===============");
        return name;
    }

    @Override
    public void doSecond() {
        System.out.println("===========doSecond方法被调用了===============");
//        System.out.println("===========doSecond方法被调用了===============" + 10 / 0);
    }
}
