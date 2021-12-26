package com.liu.boot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author lms
 * @date 2021-05-11 - 16:50
 * 模拟使用数据库表的方式实现数据的增删改查
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Department {

    private Integer id;
    private String departmentName;

}
