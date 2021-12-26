package com.liu.boot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Map;

/**
 * @author lms
 * @date 2021-05-11 - 11:06
 */

@Component  // 注入组件
@ConfigurationProperties(prefix = "person")
@Validated // 使用jsr303校验的规则
public class Person {
    private Integer id;
    private String name;
    private Integer age;
    private List<String> hobby;
    private Map<String, Object> grade;

    public Person() {
    }

    public Person(Integer id, String name, Integer age, List<String> hobby, Map<String, Object> grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.hobby = hobby;
        this.grade = grade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<String> getHobby() {
        return hobby;
    }

    public void setHobby(List<String> hobby) {
        this.hobby = hobby;
    }

    public Map<String, Object> getGrade() {
        return grade;
    }

    public void setGrade(Map<String, Object> grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", hobby=" + hobby +
                ", grade=" + grade +
                '}';
    }
}
