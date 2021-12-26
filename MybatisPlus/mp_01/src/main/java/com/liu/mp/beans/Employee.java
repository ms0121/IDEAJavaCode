package com.liu.mp.beans;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import net.sf.jsqlparser.statement.select.ValuesList;

import java.io.File;

/**
 * @author lms
 * @date 2021-05-05 - 20:03
 * MybatisPlus会默认的使用实体类的类名到数据库中找对应名字的表
 * @TableName(value = "tbl_employee"):可以指定当前的类对应的数据库中的表是哪个
 */
//@TableName(value = "tbl_employee")

public class Employee {
    /**
     * @TableId:
     *  value: 指定表中的主键列的列名，如果实体类属性名和列名一致，可以省略不指定
     *  type：指定主键的策略
     */
//    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }
}
