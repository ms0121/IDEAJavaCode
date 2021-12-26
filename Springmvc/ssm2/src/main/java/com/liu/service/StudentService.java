package com.liu.service;

import com.liu.domain.Student;

import java.util.List;

/**
 * @author lms
 * @date 2021-04-18 - 13:46
 */
public interface StudentService {
    public int addStudent(Student student);
    public List<Student> listStudent();
}
