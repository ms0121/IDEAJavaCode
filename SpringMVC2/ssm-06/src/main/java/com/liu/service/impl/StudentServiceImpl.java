package com.liu.service.impl;

import com.liu.dao.StudentDao;
import com.liu.domain.Student;
import com.liu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lms
 * @date 2021-04-29 - 10:51
 */

@Service
public class StudentServiceImpl implements StudentService {

    // 给引用类型的自动注入方式有两种： @Resource,  @Autowired
    @Autowired
    private StudentDao studentDao;

    @Override
    public int addStudent(Student student) {
        int flag = studentDao.insertStudent(student);
        return flag;
    }

    @Override
    public List<Student> findStudents() {
        List<Student> students = studentDao.selectStudents();
        return students;
    }
}
