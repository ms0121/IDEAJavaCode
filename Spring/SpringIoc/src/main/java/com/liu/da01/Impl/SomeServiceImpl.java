package com.liu.da01.Impl;

import com.liu.da01.SomeService;
import org.springframework.stereotype.Service;

/**
 * @author lms
 * @date 2021-04-25 - 11:01
 */

@Service
public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome() {
        System.out.println("该方法实现了");
    }
}
