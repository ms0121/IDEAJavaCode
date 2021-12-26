package com.liu.boot;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author lms
 * @date 2021-11-09 - 19:52
 * prefix = "lms.info"： 表示配置文件中的属性设置为lms.info.name / age的方式
 */
@ConfigurationProperties(prefix = "lms.info")
public class HelloProperties {

    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
