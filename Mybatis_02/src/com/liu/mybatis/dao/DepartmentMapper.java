package com.liu.mybatis.dao;

import com.liu.mybatis.bean.Department;

/**
 * @author lms
 * @date 2021-04-14 - 14:57
 */
public interface DepartmentMapper {
    public Department getDeptById(Integer id);
    public Department getDeptByIdPlus(Integer id);
    public Department getDeptByIdStep(Integer id);
}
