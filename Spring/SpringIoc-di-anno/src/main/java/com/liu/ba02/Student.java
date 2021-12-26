package com.liu.ba02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author lms
 * @date 2021-04-25 - 18:17
 */

// 省略value属性,创建对象的注解，不可以省略
// 使用value给属性赋值
@Component("myStudent")
public class Student {

    /**
     * 给属性赋值的两种方式：
     *      1. 直接在属性的上方添加value注解，参数是字符串
     *      2. 在set方法的上面添加注解的方式
     */
    @Value("张飞")
    private String name;
    @Value("20")
    private int age;

    public Student() {
        System.out.println("=========无参构造器==========");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
