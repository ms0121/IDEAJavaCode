package com.liu.spring.pojo;

/**
 * @author lms
 * @date 2021-04-10 - 15:09
 */
public class User {

    private String name;
    private int age;


    //  现在使用注入的方式进行赋值

    // 常规的方法对属性进行赋值的操作
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void add() {
        System.out.println("add()........");
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
