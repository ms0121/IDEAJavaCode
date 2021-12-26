package com.liu.exception;

/**
 * @author lms
 * @date 2021-04-18 - 17:19
 */
public class MyUserException extends Exception{
    public MyUserException() {
    }

    public MyUserException(String message) {
        super(message);
    }
}
