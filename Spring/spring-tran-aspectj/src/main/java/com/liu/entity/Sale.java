package com.liu.entity;

/**
 * @author lms
 * @date 2021-04-27 - 15:35
 */
public class Sale {
    private Integer id;
    private Integer gid;
    private Integer nums;

    public Sale() {
    }

    public Sale(Integer id, Integer gid, Integer num) {
        this.id = id;
        this.gid = gid;
        this.nums = num;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getNum() {
        return nums;
    }

    public void setNum(Integer num) {
        this.nums = num;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", gid=" + gid +
                ", num=" + nums +
                '}';
    }
}
