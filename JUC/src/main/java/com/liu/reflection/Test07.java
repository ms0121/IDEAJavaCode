package com.liu.reflection;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * @author lms
 * @date 2021-09-08 - 14:28
 * 使用反射获取注解里面的信息
 */
public class Test07 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        // 使用反射的方式获取注解中的类型
        Class<?> cl = Class.forName("com.liu.reflection.Student");

        // 默认获取到的是当前类的注解
        Annotation[] annotations = cl.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("annotation = " + annotation);
        }

        // 获取注解的value值
        ClassLms annotation = cl.getAnnotation(ClassLms.class);
        String value = annotation.value();
        System.out.println("value = " + value);

        // 获取属性中的注解的值
        Field name = cl.getDeclaredField("name"); // 获取指定的属性
        PropertyLms annotation1 = name.getAnnotation(PropertyLms.class); // 获取该属性上的注解信息
        System.out.println("annotation1.columName() = " + annotation1.columName());
        System.out.println("annotation1.type() = " + annotation1.type());
        System.out.println("annotation1.length() = " + annotation1.length());

        // 获取方法上的注解信息
        Method method = cl.getDeclaredMethod("study", String.class);
        MethodLms methodLms = method.getAnnotation(MethodLms.class);
        System.out.println("methodLms.value() = " + methodLms.value());
        // 获取方法中的参数类型
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        for (Type genericParameterType : genericParameterTypes) {
            System.out.println("genericParameterType = " + genericParameterType);
        }
    }
}

//定义一个作用域类的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface ClassLms {
    String value();
}

// 定义一个属性的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface PropertyLms {
    String columName();  // 数据表中的字段名

    String type(); // 当前列的类型

    int length(); // 当前列的字段长度
}

// 定义一个作用于方法的注解
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface MethodLms {
    String value();
}

@ClassLms("tbl_student")
class Student {
    @PropertyLms(columName = "tbl_id", type = "int", length = 3)
    private int id;

    @PropertyLms(columName = "tbl_name", type = "varchar", length = 20)
    private String name;

    @PropertyLms(columName = "tbl_age", type = "int", length = 3)
    private int age;

    public Student() {
    }

    @MethodLms("study")
    public void study(String str) {
        System.out.println(str + "学生正在努力学习!");
    }

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
