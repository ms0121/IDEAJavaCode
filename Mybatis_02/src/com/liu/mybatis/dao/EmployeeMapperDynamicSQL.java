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

public interface EmployeeMapperDynamicSQL {
//    <!-- 查询员工，要求携带了哪个字段查询条件就带上这个字段的值    -->
    public List<Employee> getEmpsByConditionIf(Employee employee);
}









