package com.liu.dubbo.model;

import java.io.Serializable;

/**
 * @author lms
 * @date 2021-05-23 - 15:04
 */
public class User implements Serializable {
    private Integer id;
    private String name;

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
}
