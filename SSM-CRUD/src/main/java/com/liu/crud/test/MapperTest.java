package com.liu.crud.test;

import com.liu.crud.bean.Department;
import com.liu.crud.dao.DepartmentMapper;
import com.liu.crud.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * 测试dao层的工作
 * 推荐Spring的项目可以使用Spring的单元测试，可以自动注入我们需要的组件
 *
 * 1、导入SpringTest模块
 * 2、@ContextConfiguration指定Spring配置文件的位置
 *  ，@RunWith(SpringJUnit4ClassRunner.class)让测试运行于Spring测试环境
 * 3、直接autowired要使用的组件即可
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    SqlSession sqlSession;

    /**
     * 测试DepartmentMapper
     */
    @Test
    public void testCRUD(){

//        方式一：使用xml的方式获取对象
//        1、创建SpringIOC容器
//        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//        2、从容器中获取mapper
//        DepartmentMapper departmentMapper = ac.getBean(DepartmentMapper.class);


        Department department = departmentMapper.selectByPrimaryKey(1);
        System.out.println(department.getDeptName() + " " + department.getDeptId());

//        1、插入几个部门
//        departmentMapper.insertSelective(new Department(null,"开发部"));
//        departmentMapper.insertSelective(new Department(null,"测试部"));

//        2、生成员工数据
//        employeeMapper.insertSelective(new Employee(null, "Jerry", "M", "Jerry@123.com", 1));

        // 批量将信息插入到数据表中
//        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//        for (int i = 0; i < 1000; i++) {
//            String uid = UUID.randomUUID().toString().substring(0, 5) + i;
//            mapper.insertSelective(new Employee(null, uid, "w", uid + "@qq.com",2));
//        }
//        System.out.println("批量添加成功!");


    }
}

