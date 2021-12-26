package com.liu.service;

import org.springframework.stereotype.Service;

/**
 * @author lms
 * @date 2021-05-08 - 15:52
 */
@Service
public class HelloService {

    public String sayHello(String name){
        return "hello" + name;
    }
}
