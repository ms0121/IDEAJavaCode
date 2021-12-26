package com.liu.boot.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.liu.boot.service.StudentService;
import org.springframework.stereotype.Component;

/**
 * @author lms
 * @date 2021-05-23 - 21:18
 */
@Component
@Service(interfaceClass = StudentService.class) // <dubbo:service interface.....>
public class StudentServiceImpl implements StudentService {

    @Override
    public Integer queryAllStudentCount() {
        return 1250;
    }
}
