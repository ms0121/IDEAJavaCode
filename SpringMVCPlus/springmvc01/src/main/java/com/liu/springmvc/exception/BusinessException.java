package com.liu.springmvc.exception;

/**
 * @author lms
 * @date 2021-09-26 - 10:39
 */
public class BusinessException extends RuntimeException {

    private Integer code = 400;
    private String msg = "业务异常";

    public BusinessException() {
        super("业务异常");
    }

    public BusinessException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public BusinessException(Integer code) {
        super("业务异常");
        this.code = code;
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
}
