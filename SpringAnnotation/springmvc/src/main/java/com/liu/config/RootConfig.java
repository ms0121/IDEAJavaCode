package com.liu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @author lms
 * @date 2021-05-08 - 15:31
 */
//spring的容器不扫描controller注解，父容器
@ComponentScan(value = "com.liu", excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Controller.class)
})
public class RootConfig {

}
