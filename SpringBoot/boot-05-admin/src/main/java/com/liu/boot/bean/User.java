package com.liu.boot.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lms
 * @date 2021-05-10 - 14:09
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user") // 指定对应的是数据库中的哪张表，可不写
public class User {
    @TableField(exist = false) // 代表当前的属性在表中不存在
    private String userName;
    @TableField(exist = false)
    private String password;


    // 以下是数据库字段
    private Long id;
    private String name;
    private Integer age;
    private String email;

}
