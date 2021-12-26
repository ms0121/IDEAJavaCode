package com.liu.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lms
 * @date 2021-09-08 - 9:13
 */
//自定义注解
@MyAnnotation(name = "Test01")
public class Test01 {

    @MyAnnotation(name = "say")
    public void say(){
        System.out.println("hello ");
    }

}


// 表示当前该注解只能使用在类和方法上
@Target({ElementType.TYPE, ElementType.METHOD})
// 表示运行时存储
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation{

    // 自定义注解的属性： 参数类型 + 参数名称();
    String name();

    // 如果参数有默认值可以在注解上不填写
    int id() default 1;

    // 也可以是数组的形式，如果参数名只有一个value，就可以不写参数名称
    String[] value() default {"北京", "天津"};

}


