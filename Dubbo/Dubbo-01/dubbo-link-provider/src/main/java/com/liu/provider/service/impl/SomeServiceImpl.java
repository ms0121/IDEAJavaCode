package com.liu.provider.service.impl;

import com.liu.provider.service.SomeService;

/**
 * @author lms
 * @date 2021-05-23 - 11:41
 */

public class SomeServiceImpl implements SomeService {

    @Override
    public String Hello(String msg) {
        return "hello " + msg;
    }
}
