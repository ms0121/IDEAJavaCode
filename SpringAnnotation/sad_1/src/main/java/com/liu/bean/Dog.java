package com.liu.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author lms
 * @date 2021-05-07 - 15:48
 */

@Component
public class Dog {

    public Dog(){
        System.out.println("dog 构造方法");
    }

    @PostConstruct
    public void init() {
        System.out.println("dog的初始化方法");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("dog的销毁方法");
    }

}
