package com.liu.boot;

import com.liu.boot.bean.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Kboot01ApplicationTests {

    @Autowired
    private Person person;

    @Test
    void contextLoads() {
        System.out.println("person = " + person);
    }

}
