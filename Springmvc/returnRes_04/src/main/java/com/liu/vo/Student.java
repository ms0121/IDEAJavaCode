package com.liu.vo;

/**
 * @author lms
 * @date 2021-04-17 - 14:28
 */
public class Student {

    /**
     * 属性名必须和请求页面的传过来的参数名一致
     */

    private String name;
    private Integer age;

    public Student() {
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
