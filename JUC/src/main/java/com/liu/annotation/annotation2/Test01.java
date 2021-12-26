package com.liu.annotation.annotation2;

import java.lang.annotation.*;
import java.lang.reflect.AnnotatedType;

/**
 * @author lms
 * @date 2021-10-29 - 21:25
 */
public class Test01 {

    @MyAnnotation
    public void say(){

    }

    public static void main(String[] args) {
        Test01 test01 = new Test01();
        Class<? extends Test01> clazz = test01.getClass();
        AnnotatedType[] annotateds = clazz.getAnnotatedInterfaces();
        for (AnnotatedType annotated : annotateds) {
            System.out.println("annotated = " + annotated);
        }
    }
}

/**
 * @Target: 用于描述当前注解的使用范围
 * @Retention 表示需要在什么级别上保存该注解信息，用于描述注解的生命周期
 * @Documented 说明该注解将被包含在javadoc中
 * @Inherited 说明子类可以继承父类的该注解
 */
@Target(value = {ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@interface MyAnnotation {

}
