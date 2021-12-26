package com.liu.AOP.aopAnnotation;

import org.springframework.stereotype.Component;

/**
 * @author lms
 * @date 2021-04-12 - 12:47
 */
// 被增强的类（即功能要实现修改的类）
@Component
public class User {

    public void add() {
        System.out.println("add()...............");
    }
}
