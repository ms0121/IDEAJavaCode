package com.liu.vo;

/**
 * @author lms
 * @date 2021-04-28 - 15:30
 */
public class Student {
    private String name;
    private Integer age;

    public Student() {
        System.out.println("==========无参构造方法=============");
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
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
