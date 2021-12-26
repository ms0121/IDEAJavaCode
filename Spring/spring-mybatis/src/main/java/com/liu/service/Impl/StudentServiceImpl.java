package com.liu.service.Impl;

import com.liu.dao.StudentDao;
import com.liu.domain.Student;
import com.liu.service.StudentService;

import java.util.List;

/**
 * @author lms
 * @date 2021-04-27 - 8:58
 */
public class StudentServiceImpl implements StudentService {

    // 要调用dao的函数，需要添加引用类型
    // 使用配置文件的方式，所以需要set方法
    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public int addStudent(Student student) {
        int nums = studentDao.insertStudent(student);
        return nums;
    }

    @Override
    public List<Student> queryStudents() {
        List<Student> students = studentDao.selectStudent();
        return students;
    }
}
