package com.liu.mp.beans;

import com.baomidou.mybatisplus.annotations.TableLogic;

/**
 * @author lms
 * @date 2021-05-06 - 21:42
 */
public class User {
    private Integer id;
    private String name;

    @TableLogic // 表示当前的这个属性为逻辑删除字段
    private Integer logicFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLogicFlag() {
        return logicFlag;
    }

    public void setLogicFlag(Integer logicFlag) {
        this.logicFlag = logicFlag;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", logicFlag=" + logicFlag +
                '}';
    }
}
