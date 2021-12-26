package com.liu.dao;

import com.liu.domain.Student;
import java.util.List;


/**
 * @author lms
 * @date 2021-04-29 - 10:45
 */
public interface StudentDao {
    int insertStudent(Student student);
    List<Student> selectStudents();
}
