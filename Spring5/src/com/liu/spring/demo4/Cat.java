package com.liu.spring.demo4;

import com.liu.spring.demo2.Course;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author lms
 * @date 2021-04-11 - 10:18
 */
//  3 、工厂 bean ：在配置文件定义 bean  类型可以和返回类型不一样
//        第一步 创建类，让这个类作为工厂 bean，实现接口 FactoryBean
//        第二步 实现接口里面的方法，在实现的方法中定义返回的 bean 类型
public class Cat implements FactoryBean<Course> {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public Course getObject() throws Exception {
        Course course = new Course();
        course.setName("我是course");
        return course;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
