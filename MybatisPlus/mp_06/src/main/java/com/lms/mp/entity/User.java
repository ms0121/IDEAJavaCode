package com.lms.mp.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author lms
 * @date 2021-07-16 - 10:40
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    // id 在mp中默认使用的是雪花算法进行增长设置
    private Long id;
    private String name;
    private Integer age;
    private String email;

    // 只有当前的属性设置了TableField属性，才可以使用handler进行设置值
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    // 插入或者修改的时候有值
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


    // 实现乐观锁的设置，使用版本号进行控制,要使用乐观锁，必须设置配置文件(类)
    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;


    // 逻辑删除的标志属性，并设置初始值，0表示有效，1代表已删除
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer deleted;






}
