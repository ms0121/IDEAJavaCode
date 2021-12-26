package com.liu.ba03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    /**
     * @有引用类型的赋值方式:
     * @Autowired:spring框架提供的注解，实现引用类型的赋值，spring中通过注解给
     *            @引用类型赋值，使用的是自动注入原理，支持byName，byType
     * @Autowired：默认使用的是byType自动注入
     * @Autowired位置： 1.在属性定义的上面，无需set方法，推荐使用
     *                 2. 在set方法的上面
     *
     *  如果要使用byName的方式，需要做以下的是:
     *      1. 在属性的上面加入@Autowired
     *      2. 在属性的上面加入@Qualifier("bean的id值")：表示使用指定名称的bean完成赋值
     *
     *  @Autowired：属性required，是一个boolean类型的，默认是true
     *      required = true，表示引用类型赋值失败，程序会报错，并终止执行
     *      required = false，引用类型如果赋值失败，程序会正常执行，引用类型是null
     */
    // 使用byName
//    @Autowired
//    @Qualifier("mySchool")

    @Autowired // 默认使用byType方式
    private School school;

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
                ", school=" + school +
                '}';
    }
}
