package com.liu.exce;

/**
 * @author lms
 * @date 2021-04-27 - 16:03
 */

// 自定义的运行时类
public class NotEnoughException extends RuntimeException {

    public NotEnoughException() {
    }

    public NotEnoughException(String message) {
        super(message);
    }
}
