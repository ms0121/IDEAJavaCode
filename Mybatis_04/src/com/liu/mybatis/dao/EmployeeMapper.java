package com.liu.mybatis.dao;

import com.liu.mybatis.bean.Employee;

import java.util.List;

public interface EmployeeMapper {
	//
    public Employee getEmpById(Integer id);
    // 返回数据表中的所有记录信息
    public List<Employee> getEmpList();
    // 数据的插入
    public void addEmp(Employee employee);
}
