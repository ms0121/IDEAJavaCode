package com.liu.service;

import com.liu.domain.Student;

import java.util.List;

/**
 * @author lms
 * @date 2021-04-29 - 10:49
 */
public interface StudentService {
    int addStudent(Student student);
    List<Student> findStudents();
}
