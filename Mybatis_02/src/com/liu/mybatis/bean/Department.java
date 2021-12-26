package com.liu.mybatis.bean;

import java.util.List;

/**
 * @author lms
 * @date 2021-04-14 - 14:00
 */
public class Department {

    private Integer id;
    private String departmentName;
    private List<Employee> emps;

    public Department(){

    }

    public Department(Integer id, String departmentName) {
        this.id = id;
        this.departmentName = departmentName;
    }

    public Department(Integer id, String departmentName, List<Employee> emps) {
        this.id = id;
        this.departmentName = departmentName;
        this.emps = emps;
    }

    public List<Employee> getEmps() {
        return emps;
    }

    public void setEmps(List<Employee> emps) {
        this.emps = emps;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
