package com.liu.es02.pojo;

import org.springframework.stereotype.Component;

/**
 * @author lms
 * @date 2021-10-26 - 20:09
 */

@Component
public class User {

    private String name;
    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
