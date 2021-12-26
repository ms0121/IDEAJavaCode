package com.liu.mybatis.dao;

import com.liu.mybatis.bean.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author lms
 * @date 2021-04-13 - 16:15
 */

public interface EmployeeMapperPlus {

    public Employee getEmpById(Integer id);
    public Employee getEmpAndDept(Integer id);
    public List<Employee> getEmpsByDeptId(Integer deptId);

}









