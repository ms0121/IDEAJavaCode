package com.liu.spring.pojo;

/**
 * @author lms
 * @date 2021-04-11 - 8:20
 */
public class Dog {
    private String name;
    private int age;
    private String color;
    private String address;

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
