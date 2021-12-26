package com.liu.boot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

import javax.print.attribute.standard.MediaSize;

/**
 * @author lms
 * @date 2021-05-16 - 9:59
 * @ImportResource：指明配置文件xml的位置，使用配置文件的方式进行组件的初始化操作
 */

@Component  // 将当前的类（组件）直接添加到容器中，配置类就不可以再次进行加入
@ConfigurationProperties(prefix = "mycat")
public class Pet {
    private String name;


    public Pet() {
    }

    public Pet(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                '}';
    }
}
