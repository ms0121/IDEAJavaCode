package com.liu.springmvc.controller;

import com.liu.springmvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lms
 * @date 2021-09-25 - 14:00
 * 返回JavaBean对象的json格式数据信息
 *
 * 注意：当发起ajax请求的时候， @ResponseBody会将数据转化成为json的格式，响应给ajax的回调函数
 *      不使用 @ResponseBody无法返回json数据，从而导致出错
 *
 * @RequestBody： 规定请求的参数必须是json格式的字符串，注解要设置在参数中
 *    1.  @RequestBody: 处理不是默认类型的内容，
 *    2. 请求的参数一定是Json格式的字符串
 *
 */
@Controller
@RequestMapping("user")
public class UserController {

    /**
     * @ResponseBody 表示返回的是json形式的数据对象信息
     *  一般将该注解写在方法的上面，也可以写在方法的返回值类型的前面
     * @return
     */
    @RequestMapping("query01")
    @ResponseBody
    public User query01(){
        User user = new User();
        user.setAge(20);
        user.setId(1);
        user.setName("zhangsan");
        return user;
    }


    /**
     * @return
     */
    @RequestMapping("query02")
    public @ResponseBody User query02(){
        User user = new User();
        user.setAge(30);
        user.setId(2);
        user.setName("lisi");
        return user;
    }


    /**
     * 如果不使用@ResponseBody只能返回ModelAndView对象或者String类型的视图
     * @return
     */
    @RequestMapping("query03")
    @ResponseBody
    public List<User> query03(){
        ArrayList<User> list = new ArrayList<>();
        User user = new User();
        user.setAge(20);
        user.setId(1);
        user.setName("zhangsan");

        User user1 = new User();
        user1.setAge(30);
        user1.setId(2);
        user1.setName("lisi");

        list.add(user);
        list.add(user1);
        return list;
    }


}
