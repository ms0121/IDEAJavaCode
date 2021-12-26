package com.liu.exception;

/**
 * @author lms
 * @date 2021-04-18 - 17:22
 */
// 当用户的姓名出现问题的时候抛出的异常
public class NameException extends MyUserException {
    public NameException() {
    }

    public NameException(String message) {
        super(message);
    }
}
