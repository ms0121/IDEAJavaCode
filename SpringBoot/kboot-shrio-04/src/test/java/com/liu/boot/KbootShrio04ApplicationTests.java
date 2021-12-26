package com.liu.boot;

import com.liu.boot.pojo.User;
import com.liu.boot.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KbootShrio04ApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        User lisa = userService.selectUserByName("Lisa");
        System.out.println("lisa = " + lisa);
    }

}
