package com.liu.boot.bean;

import lombok.*;

/**
 * @author lms
 * @date 2021-05-09 - 15:36
 */

@Data  // 给来添加get和set方法
@ToString  // 添加toString方法
@EqualsAndHashCode  // 重写HashCode方法
@NoArgsConstructor  // 午安构造器
@AllArgsConstructor  // 全参构造器

public class Person {
    private Integer id;
    private String name;
    private Integer age;

}
