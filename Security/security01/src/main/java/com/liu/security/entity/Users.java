package com.liu.security.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author lms
 * @date 2021-10-02 - 23:55
 */
@Data
@TableName("user")
public class Users {
    private String id;
    private String username;
    private String password;
}
