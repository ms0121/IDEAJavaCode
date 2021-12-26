package com.liu.crud.service;

import com.liu.crud.bean.Employee;
import com.liu.crud.bean.EmployeeExample;
import com.liu.crud.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lms
 * @date 2021-05-01 - 16:02
 */

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    public List<Employee> getAll() {
        List<Employee> employees = employeeMapper.selectByExampleWithDept(null);
        return employees;
    }

    public void saveEmployee(Employee employee) {
        employeeMapper.insertSelective(employee);
    }

    // 检查用户名是否可用
    public boolean checkUser(String empName){
        // 拼装查询条件
        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        criteria.andEmpNameEqualTo(empName);
        long count = employeeMapper.countByExample(example);
        return count == 0;
    }


//    根据用户id获取详细的信息
    public Employee getEmployee(Integer id){
        Employee employee = employeeMapper.selectByPrimaryKey(id);
        return employee;
    }

//    保存修改的员工信息
    public void updateEmp(Employee employee){
        employeeMapper.updateByPrimaryKeySelective(employee);
    }

    // 删除指定的员工
    public void deleteEmp(Integer id) {
        employeeMapper.deleteByPrimaryKey(id);
    }

    // 批量删除员工数据信息
    public void deleteEmpBatch(List<Integer> list) {
        // 拼接要删除的条件example
        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        criteria.andEmpIdIn(list);
        employeeMapper.deleteByExample(example);
    }

}
