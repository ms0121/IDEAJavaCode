package com.liu.bean;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author lms
 * @date 2021-05-07 - 8:58
 */
public class Person {

    /**
     * 使用@Value给属性赋值(等价于在bean.xml配置文件中进行的赋值)
     * 1.基本赋值
     * 2.可以写spel表达式： #{}
     * 3.可以写 ${}，取出配置文件中的值（在运行环境变量里面的值）
     */
    @Value("张三")
    private String name;
    @Value("#{20+3}")
    private Integer age;
    @Value("${person.nickName}")
    private String nickName;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Person() {
    }

    public Person(String name, Integer age) {
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
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
