package com.liu.dao;

import com.liu.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lms
 * @date 2021-05-05 - 8:16
 */
public interface StudentDao {
    List<Student> selectStudents();
    int insertStudent(Student student);

    // 多个参数直接 @Param进行命名
    List<Student> selectMutilParam(@Param("myname") String name, @Param("myage") Integer age);

//    计算当前的员工数据信息
    int studentCount();

//    使用动态的sql语句进行查询信息
    List<Student> selectStudentByIf(Student student);

    List<Student> selectStudentByWhere(Student student);

    // 传入的参数是一个list的集合
    List<Student> studentForeach(List<Integer> list);
}
