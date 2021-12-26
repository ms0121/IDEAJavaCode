package com.liu.dao;

import com.liu.domain.Student;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author lms
 * @date 2021-04-18 - 13:43
 */
public interface StudentDao {
    public int addStudent(Student student);
    public List<Student> listStudent();
}
