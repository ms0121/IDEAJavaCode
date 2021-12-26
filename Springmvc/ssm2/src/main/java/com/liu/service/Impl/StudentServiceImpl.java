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
 * @date 2021-04-18 - 13:46
 */

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentDao studentDao;

    @Override
    public int addStudent(Student student) {
        int flag = studentDao.addStudent(student);
        return flag;
    }

    @Override
    public List<Student> listStudent() {
        return studentDao.listStudent();
    }
}
