package com.liu.jdbc.entity;

/**
 * @author lms
 * @date 2021-04-12 - 14:49
 */
public class Book {
    private int userId;
    private String userName;
    private String uStatus;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getuStatus() {
        return uStatus;
    }

    public void setuStatus(String uStatus) {
        this.uStatus = uStatus;
    }

    @Override
    public String toString() {
        return "Book{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", uStatus='" + uStatus + '\'' +
                '}';
    }
}
