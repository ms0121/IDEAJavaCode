package com.liu.service;

import com.liu.domain.Student;

import java.util.List;

/**
 * @author lms
 * @date 2021-04-17 - 23:57
 */
public interface StudentService {
    public int insertStudent(Student student);
    public List<Student> findStudents();
}
