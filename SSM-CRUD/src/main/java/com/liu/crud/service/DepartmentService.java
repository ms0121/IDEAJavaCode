package com.liu.crud.service;

import com.liu.crud.bean.Department;
import com.liu.crud.dao.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lms
 * @date 2021-05-02 - 16:04
 */

@Service
public class DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    public List<Department> getDepartments() {
        List<Department> dpets = departmentMapper.selectByExample(null);
        return dpets;
    }
}
