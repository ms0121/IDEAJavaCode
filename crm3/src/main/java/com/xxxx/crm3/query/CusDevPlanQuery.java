package com.xxxx.crm3.query;

import com.xxxx.crm3.base.BaseQuery;

/**
 * @author lms
 * @date 2021-10-23 - 9:47
 */
public class CusDevPlanQuery extends BaseQuery {

    private String customerName;
    private String createMan;

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
}
