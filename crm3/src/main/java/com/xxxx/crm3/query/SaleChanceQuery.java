package com.xxxx.crm3.query;

import com.xxxx.crm3.base.BaseQuery;

/**
 * @author lms
 * @date 2021-10-10 - 15:57
 */
public class SaleChanceQuery extends BaseQuery {
    private String customerName;
    private String createMan;
    private Integer state;

    // 客户开发计划字段(只显示当前登录用户下的客户信息)
    private String devResult; // 开发状态
    private String assignMan; // 指派人

    public String getDevResult() {
        return devResult;
    }

    public void setDevResult(String devResult) {
        this.devResult = devResult;
    }

    public String getAssignMan() {
        return assignMan;
    }

    public void setAssignMan(String assignMan) {
        this.assignMan = assignMan;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCreateMan() {
        return createMan;
    }

    public void setCreateMan(String createMan) {
        this.createMan = createMan;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
