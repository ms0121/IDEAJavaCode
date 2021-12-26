package com.liu.boot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author lms
 * @date 2021-05-11 - 16:51
 */

@Data
@NoArgsConstructor
public class Employee {

    private Integer id;
    private String lastName;
    private Integer gender;  // 对于性别在数据表中都是使用Integer的0和1代表
    private Department department;
    private Date birth;

    public Employee(Integer id, String lastName, Integer gender, Department department) {
        this.id = id;
        this.lastName = lastName;
        this.gender = gender;
        this.department = department;
        this.birth = new Date();
    }
}
