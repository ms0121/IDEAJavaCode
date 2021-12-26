package com.liu.security.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

/**
 * @author lms
 * @date 2021-10-02 - 22:33
 */
@Data
@TableName("user")
public class Users {
    private String id;
    private String username;
    private String password;
}
