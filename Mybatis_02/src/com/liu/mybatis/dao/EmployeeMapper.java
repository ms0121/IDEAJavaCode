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

public interface EmployeeMapper {
    // 查询
    public Employee getEmpById(Integer id);
    // 添加
    public void addEmp(Employee employee);
    // 修改
    public void updateEmp(Employee employee);
    // 删除
    public void deleteEmpById(Integer id);

    // 根据id和名字进行查询，多个参数查询的方法，使用注解进行注释值
    public Employee getEmpByIdAndName(@Param("id") Integer id, @Param("lastName") String name);

    // 查询返回一个列表
    public List<Employee> queryForEmps(String lastName);

    // 返回一条员工的记录信息，即对应的键值对进行封装
    public Map<String, Object> getEmpByIdReMap(Integer id);

    // 返回一个封装好的map信息（键是员工的id，值是员工bean）
    @MapKey("id")  // 告诉mybatis封装这个map的时候使用哪个属性作为map中的key
    public Map<Integer, Employee> getEmpByreturnMap(String lastName);
}









