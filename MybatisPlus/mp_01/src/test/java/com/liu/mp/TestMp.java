package com.liu.mp;

import com.baomidou.mybatisplus.plugins.Page;
import com.liu.mp.beans.Employee;
import com.liu.mp.mapper.EmployeeMapper;
import com.mchange.v1.identicator.IdList;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author lms
 * @date 2021-05-05 - 21:19
 */
public class TestMp {

    private ApplicationContext ioc =
            new ClassPathXmlApplicationContext("applicationContext.xml");


    public EmployeeMapper getEm(){
        // 使用的是Spring中的ioc方法创建对象,"employeeMapper"指定获取的对象名称(默认是类名的首字母小写)，还有类型
        return ioc.getBean("employeeMapper", EmployeeMapper.class);
    }


//    删除操作
    @Test
    public void delete(){
        EmployeeMapper employeeMapper = getEm();

//        1.根据id进行删除数据
//        Integer flag = employeeMapper.deleteById(2);
//        System.out.println("flag = " + flag);


//        2.根据指定的条件进行删除
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("last_name", "Tom3");
//        map.put("email", "tom3@atguigu.com");
//        Integer flag = employeeMapper.deleteByMap(map);
//        System.out.println("flag = " + flag);


//        3.批量删除
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(3);
//        Integer flag = employeeMapper.deleteBatchIds(list);
//        System.out.println("flag = " + flag);

    }


//    查询操作
    @Test
    public void select(){
        EmployeeMapper employeeMapper = getEm();
//      1. 根据id进行查询
//        Employee employee = employeeMapper.selectById(7);

//      2. 拼接多个字段进行查询数据
//        将多个要查询的字段封装在employee对象中即可
//        Employee employee = new Employee();
//        employee.setLastName("利路修");
//        employee.setGender(0);
//        Employee employee1 = employeeMapper.selectOne(employee);
//        System.out.println("employee1 = " + employee1);


//        3.通过多个id的值进行查询相应的信息
//        List<Integer> idList = new ArrayList<>();
//        idList.add(1);
//        idList.add(4);
//        idList.add(7);
//        idList.add(8);
//        List<Employee> employees = employeeMapper.selectBatchIds(idList);
//        for (Employee employee : employees) {
//            System.out.println("employee = " + employee);
//        }


//      4.通过map进行封装查询的条件,
//        HashMap<String, Object> map = new HashMap<>();
////        map中的key必须使用表中相应的字段名
//        map.put("last_name","利路修");
//        map.put("gender", 0);
//        List<Employee> employees = employeeMapper.selectByMap(map);
//        for (Employee employee : employees) {
//            System.out.println("employee = " + employee);
//        }


//      5.分页查询
        List<Employee> employees = employeeMapper.selectPage(new Page<>(3, 2), null);
        System.out.println("employees = " + employees);
    }



//   更新的操作
    @Test
    public void updateEmp() {
        EmployeeMapper employeeMapper = getEm();
        Employee employee = new Employee();
        employee.setId(3);
        employee.setLastName("张三丰");
        employee.setEmail("zhangsanfeng@126.com");
        employee.setGender(1);
//        employee.setAge(26);
//        Integer flag = em.insert(employee);

//        存在什么字段就修改什么字段
//        Integer flag = employeeMapper.updateById(employee);

//        修改所有的字段，不存在就设置默认值
        Integer flag = employeeMapper.updateAllColumnById(employee);
        System.out.println("flag = " + flag);
        System.out.println("================================");
        // 获取当前数据在数据库中的主键值
        Integer id = employee.getId();
        System.out.println("id = " + id);
    }



    @Test
    public void test1() throws SQLException {
        DataSource dataSource = ioc.getBean("dataSource", DataSource.class);
        System.out.println("dataSource = " + dataSource);
        Connection conn = dataSource.getConnection();
        System.out.println("conn = " + conn);
    }

}
