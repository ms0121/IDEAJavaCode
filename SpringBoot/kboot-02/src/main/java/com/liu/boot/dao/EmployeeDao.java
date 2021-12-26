package com.liu.boot.dao;

import com.liu.boot.pojo.Department;
import com.liu.boot.pojo.Employee;
import com.liu.boot.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lms
 * @date 2021-05-11 - 16:56
 */
@Repository
public class EmployeeDao {

    // 存放数据一般都是使用map进行
    private static Map<Integer, Employee> employees = null;

    @Autowired
    private DepartmentDao departmentDao;

    // 模拟数据表。在初始化的时候就显示数据信息，所以将数据放在static中
    static {
        // 创建一个Employee数据表
        employees = new HashMap<>();

        // 给数据表添加数数据信息
        employees.put(1001, new Employee(1001, "Azhangsan", 0, new Department(101, "教学部")));
        employees.put(1002, new Employee(1002, "Bzhangsan", 1, new Department(102, "市场部")));
        employees.put(1003, new Employee(1003, "Czhangsan", 0, new Department(103, "教研部")));
        employees.put(1004, new Employee(1004, "Dzhangsan", 1, new Department(104, "运营部")));
        employees.put(1005, new Employee(1005, "Ezhangsan", 0, new Department(105, "后勤部")));
    }

    // 主键的自增
    private static Integer initId = 1006;

    // 增加一个员工信息
    public void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);
    }

    // 查询全部的员工信息
    public Collection<Employee> getAll() {
        return employees.values();
    }

    // 通过id查询员工信息
    public Employee getEmployeeById(Integer id) {
        return employees.get(id);
    }

    // 删除员工的信息
    public void delete(Integer id) {
        employees.remove(id);
    }

}


















