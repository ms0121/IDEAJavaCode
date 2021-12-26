package com.liu.boot.dao;

import com.liu.boot.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lms
 * @date 2021-05-11 - 16:56
 */

@Repository
public class DepartmentDao {

    // 存放数据一般都是使用map进行
    private static Map<Integer, Department> departments = null;

    // 模拟数据表。在初始化的时候就显示数据信息，所以将数据放在static中
    static {
        // 创建一个Department数据表
        departments = new HashMap<>();

        // 给数据表添加数数据信息
        departments.put(101, new Department(101, "教学部"));
        departments.put(102, new Department(102, "市场部"));
        departments.put(103, new Department(103, "教研部"));
        departments.put(104, new Department(104, "运营部"));
        departments.put(105, new Department(105, "后勤部"));
    }


    // 获取所有的部门信息
    public Collection<Department> getDepartment() {
        return departments.values();
    }

    // 根据id进行查询部门信息
    public Department getDepartmentById(Integer id) {
        return departments.get(id);
    }
}
















