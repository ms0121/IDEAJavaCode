package com.liu.session.vo;

/**
 * @author lms
 * @date 2021-10-02 - 19:12
 */
public class ResultInfo {
    private Integer code = 200;
    private String msg = "登录成功";
    private Object data;

    public ResultInfo() {
    }

    public ResultInfo(Integer code) {
        this.code = code;
    }

    public ResultInfo(String msg) {
        this.msg = msg;
    }

    public ResultInfo(Object data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
