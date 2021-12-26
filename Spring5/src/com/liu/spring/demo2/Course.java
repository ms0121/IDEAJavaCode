package com.liu.spring.demo2;

/**
 * @author lms
 * @date 2021-04-11 - 9:22
 */

// 演示在集合中注入对象类型的数据信息
public class Course {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                '}';
    }
}
