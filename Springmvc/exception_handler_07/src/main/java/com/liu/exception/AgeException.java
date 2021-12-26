package com.liu.exception;

/**
 * @author lms
 * @date 2021-04-18 - 17:23
 */

// 当用户的名字出现异常的时候抛出
public class AgeException extends MyUserException {
    public AgeException() {
    }

    public AgeException(String message) {
        super(message);
    }
}
