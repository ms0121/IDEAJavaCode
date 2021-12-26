package com.xxxx.crm3.model;

/**
 * @author lms
 * @date 2021-09-27 - 20:27
 * 用于返回user对象中的部分属性信息
 */
public class UserModel {

//    private Integer userId;
    // 将用户的userIdStr进行加密处理
    private String userIdStr;
    private String userName;
    private String trueName;

    public String getUserIdStr() {
        return userIdStr;
    }

    public void setUserIdStr(String userIdStr) {
        this.userIdStr = userIdStr;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }
}
