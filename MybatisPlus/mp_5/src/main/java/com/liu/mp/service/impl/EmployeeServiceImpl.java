package com.liu.mp.service.impl;

import com.liu.mp.beans.Employee;
import com.liu.mp.mapper.EmployeeMapper;
import com.liu.mp.service.EmployeeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lms
 * @since 2021-05-06
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
