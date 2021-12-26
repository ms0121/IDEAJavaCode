package com.liu.boot.controller;

import com.liu.boot.bean.Car;
import com.liu.boot.bean.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lms
 * @date 2021-05-09 - 10:59
 */

// 以字符串的方式写给浏览器，而不是跳转到页面
//@ResponseBody
//@Controller


@Slf4j  // 日记插件
@RestController  // 里面包含了@ResponseBody， @Controller这两个注解
public class HelloController {

    @Autowired
    private Car car;

    @RequestMapping("/car")
    public Car car() {
        return car;
    }


    @RequestMapping("/hello")
    public String hello() {
        log.info("请求进来了.........");
        return "hello，Springboot！";
    }

    @RequestMapping("/person")
    public Person name() {
        log.info("请求进来了，正在创建person对象,请等待...........");
        Person person = new Person(1, "张三", 10);
        return person;
    }

}
