package com.liu.annotation.annotation2;

import java.lang.annotation.*;
import java.lang.reflect.Method;

/**
 * @author lms
 * @date 2021-10-29 - 21:36
 */

@MyAnnotation2
public class Test02 {

    @MyAnnotation2(name = "lisi", age = 20, value = {"哈佛", "MIT"})
    public void say() {

    }

    @MyAnnotation3
    public void hello() {

    }

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("com.liu.annotation.annotation2.Test02");
//        Method[] declaredMethods = clazz.getDeclaredMethods();
//        for (Method declaredMethod : declaredMethods) {
//            System.out.println("declaredMethod = " + declaredMethod);
//        }

        // 获取的类上面的注解信息
//        Annotation[] annotations = clazz.getAnnotations();
//        for (Annotation annotation : annotations) {
//            System.out.println("annotation = " + annotation);
//        }

        MyAnnotation2 annotation1 = clazz.getAnnotation(MyAnnotation2.class);
        String[] value = annotation1.value();
        for (String s : value) {
            System.out.println("s = " + s);
        }
    }
}

// 定义两个注解，分别注释Test中的两个方法
@Target(value = {ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2 {
    String name() default "lms";

    int age() default 18;

    String[] value() default {"清华", "北大"};
}


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation3 {

    String value() default "zhangsan";

}




