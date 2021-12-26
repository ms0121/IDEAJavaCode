package com.liu.boot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ImportResource;

/**
 * @author lms
 * @date 2021-05-16 - 9:59
 *
 * 1. 以前给bean组件进行默认配置属性值，可以在配置文件xml中使用下面的方式：
 *      <bean id="user01" class="com.liu.boot.bean.User">
 *         <property name="name" value="张三"/>
 *         <property name="age" value="19"/>
 *     </bean>
 *
 * 2.  当前直接使用：@ConfigurationProperties(prefix = "myuser")
 *      表示在主配置文件 application.properties中进行查找配置，匹配前缀是myuser的
 *
 *
 * 3.也可以使用 @ImportResource("")的方式导入原生配置文件xml的方式进行初始化组件，比如Pet类
 *
 * 直接给组件的属性进行配置（使用的是主配置文件中的值）
 */
@ConfigurationProperties(prefix = "myuser")
public class User {
    private String name;
    private Integer age;

    public User() {
    }

    public User(String name, Integer age) {
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
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
