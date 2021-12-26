package com.liu.springmvc.controller;

import com.liu.springmvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author lms
 * @date 2021-09-25 - 10:27
 * 参数传递：
 *  1.基本数据类型
 *
 */

@Controller
@RequestMapping("param")
public class ParamsController {

    /**
     * 基本数据类型绑定：
     *      参数值必须存在，如果不存在，又不设置默认值，则会报500异常错误
     * @param age
     * @param money
     */
    @RequestMapping("/test01")
    public void test01(int age, double money){
        System.out.println("age = " + age + ", money = " + money);
    }

    /**
     * 基本数据类型绑定：
     *      参数值必须存在，如果不存在，又不设置默认值，则会报500异常错误
     *      通过注解RequestParam标注传递的参数的默认值，如果不传递参数则使用默认值
     *      传递了参数则使用传递的，
     * @param age
     * @param money
     */
    @RequestMapping("/test02")
    public void test02(@RequestParam(defaultValue = "10") int age,
                       @RequestParam(defaultValue = "20.3") double money){
        System.out.println("age = " + age + ", money = " + money);
    }

    /**
     * 基本数据类型绑定：
     *      参数值必须存在，如果不存在，又不设置默认值，则会报500异常错误
     *      通过注解RequestParam标注传递的参数的默认值，如果不传递参数则使用默认值
     *      传递了参数则使用传递的，
     *      给传递的参数设置属性名（意思就是传递的路径必须使用定义的名字，比如使用userAge=20&userMoney=30.3）
     *      不这样子进行参数的传递使用，将会发生错误
     * @param age
     * @param money
     */
    @RequestMapping("/test03")
    public void test03(@RequestParam(defaultValue = "10", name = "userAge") int age,
                       @RequestParam(defaultValue = "20.3", name = "userMoney") double money){
        System.out.println("age = " + age + ", money = " + money);
    }


    /**
     * 如果是基本数据类型，推荐使用它的包装类型
     *      请求的参数名要和形参名保持一致（在未设置别名的情况下），包装类型的默认值是null，所以不传递值默认是null
     *      可以通过RequestParam注解进行设置默认值和别名
     * @param age
     * @param money
     */
    @RequestMapping("/test04")
    public void test04(Integer age, Double money){
        System.out.println("age = " + age + ", money = " + money);
    }


    /**
     * 字符串类型：
     *      默认值也为null
     * @param name
     * @param pwd
     */
    @RequestMapping("/test05")
    public void test05(String name, String pwd){
        System.out.println("name = " + name + ", pwd = " + pwd);
    }


    /**
     * 数组类型：
     *      传递参数格式：hobbys=sing&hobbys=dance&hobbys=rap
     * @param hobbys
     */
    @RequestMapping("/test06")
    public void test06(String[] hobbys){
        for (String hobby : hobbys) {
            System.out.println("hobby = " + hobby);
        }
    }

    /**
     * bean对象传递参数
     *      传递格式：bean对象的属性，如:id=1&name=zhangsan&age=24
     *      也就是客户端传递的参数名必须和JavaBean对象中的属性保持一致（可以选择性的传递参数）
     * @param user
     */
    @RequestMapping("/test07")
    public void test07(User user){
        System.out.println("user = " + user);
    }


    /**
     * 集合类型的数据必须设置在JavaBean对象中进行传递，不可以直接写在参数中
     * @param user
     */
    @RequestMapping("/test08")
    public void test08(User user){
        System.out.println("user = " + user);
    }




}
