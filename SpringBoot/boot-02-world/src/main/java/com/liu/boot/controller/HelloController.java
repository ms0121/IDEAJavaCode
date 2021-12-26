package com.liu.boot.controller;

import com.liu.boot.beans.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lms
 * @date 2021-05-09 - 16:56
 */
@RestController
public class HelloController {

    @Autowired
    private Person person;

    @RequestMapping("/person")
    public Person getPer() {
        return person;
    }

}
