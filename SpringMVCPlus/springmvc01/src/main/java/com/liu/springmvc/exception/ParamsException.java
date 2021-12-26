package com.liu.springmvc.exception;

/**
 * @author lms
 * @date 2021-09-26 - 10:34
 */
//自定义参数异常类
public class ParamsException extends RuntimeException {
    private Integer code = 300;
    private String msg = "参数异常";

    public ParamsException() {
        super("参数异常");
    }

    public ParamsException(Integer code) {
        super("参数异常");
        this.code = code;
    }

    public ParamsException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public ParamsException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

}
