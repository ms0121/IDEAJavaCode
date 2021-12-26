package com.liu.boot.controller;

import com.liu.boot.mapper.UserMapper;
import com.liu.boot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lms
 * @date 2021-05-12 - 20:59
 */
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/queryMapper")
    public List queryMapper() {
        List<User> users = userMapper.queryMapper();
        return users;
    }

    @GetMapping("/queryUserById/{id}")
    public User queryUserById(@PathVariable("id") Integer id) {
        User user = userMapper.queryUserById(id);
        return user;
    }


    @RequestMapping("/addUser")
    public String addUser() {
        System.out.println("收到请求");
        User user = new User(4, "lisi", "123");
        userMapper.addUser(user);
        return "添加成功！";
    }

    @GetMapping("/updateUser")
    public String updateUser() {
        User lisa = new User(4, "Lisa", "322");
        userMapper.updateUser(lisa);
        return "修改成功！";
    }


    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        userMapper.deleteUser(id);
        return "删除成功！";
    }


}
