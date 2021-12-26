package com.liu.boot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author lms
 * @date 2021-05-09 - 14:16
 */

// 导入配置文件application.properties中的内容

/**
 * 只有在容器中的组件，才会拥有SpringBoot提供的强大功能
 */
//方式1：将配置文件properties加入到组件中
//方式2： 不使用Component自动注入的方式，直接在主配置文件中开启自动注入
//@Component  // 将car组件注入到容器中

@ConfigurationProperties(prefix = "mycar")  // 获取配置文件中的那些属性值
public class Car {
    private String brand;
    private Integer price;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
