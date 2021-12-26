package com.liu.ba02;

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
}
