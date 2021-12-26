package com.liu.dao;

import com.liu.domain.Student;

import java.util.List;

/**
 * @author lms
 * @date 2021-04-17 - 23:47
 */
public interface StudentDao {
    public int insertStudent(Student student);
    public List<Student> findStudents();
}
