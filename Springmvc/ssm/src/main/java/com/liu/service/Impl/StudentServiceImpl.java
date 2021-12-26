package com.liu.service.Impl;

import com.liu.dao.StudentDao;
import com.liu.domain.Student;
import com.liu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lms
 * @date 2021-04-17 - 23:57
 */

@Service
public class StudentServiceImpl implements StudentService {

    // 引用类型自动注入，可以使用autowire或者repository
    @Resource
    private StudentDao studentDao;

    @Override
    public int insertStudent(Student student) {
        int flag = studentDao.insertStudent(student);
        return flag;
    }

    @Override
    public List<Student> findStudents() {
        return studentDao.findStudents();
    }
}
