package com.liu.mp;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.liu.mp.beans.Employee;
import com.liu.mp.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author lms
 * @date 2021-05-06 - 8:55
 *
 * 条件构造器
 */
public class TestMp2 {

    private ApplicationContext ioc =
            new ClassPathXmlApplicationContext("applicationContext.xml");


    public EmployeeMapper getEm() {
        // 使用的是Spring中的ioc方法创建对象,"employeeMapper"指定获取的对象名称(默认是类名的首字母小写)，还有类型
        return ioc.getBean("employeeMapper", EmployeeMapper.class);
    }


//    带条件的删除操作
    @Test
    public void deleteEntityWrapper(){
        EmployeeMapper employeeMapper = getEm();

        // 删除 名字为Tom并且年龄等于29岁的
        Integer flag = employeeMapper.delete(new EntityWrapper<Employee>()
                .eq("last_name", "Tom")
                .eq("age", 29)
        );
        System.out.println("flag = " + flag);
    }



//    条件构造器的修改操作
    @Test
    public void updateEntityWrapper() {
        EmployeeMapper employeeMapper = getEm();

//        需求1：将表中的 lastName='Tom', age=28的员工修改为指定的内容
        Employee employee = new Employee();
        employee.setLastName("波波老师");
        employee.setGender(0);
        employee.setEmail("bobo@qq.com");
        employee.setAge(20);

        // 将指定符合条件的员工修改为传入进来的员工信息
        Integer flag = employeeMapper.update(employee, new EntityWrapper<Employee>()
                .eq("last_name", "Tom")
                .eq("age", 28)
        );
        System.out.println("flag = " + flag);
    }


    //    条件构造器：拼接查询条件的信息
    @Test
    public void selectEntityWrapper() {
        EmployeeMapper employeeMapper = getEm();

//      需求1：我们需要分页查询 tbl_employee 表中，年龄在 18~50 之间性别为男且姓名为tom的所有用户
//        List<Employee> employees = employeeMapper.selectPage(new Page<Employee>(2, 2),
//                new EntityWrapper<Employee>()  // EntityWrapper该对象用于拼接查询的字段
//                        .between("age", 18, 50)
//                        .eq("last_name", "Tom")
//                        .eq("gender", 1)
//        );

//        同样也可以使用Condition的方式，该方式不需要创建对象，直接create即可
        List<Employee> employees = employeeMapper.selectPage(new Page<Employee>(1, 2),
                Condition.create()
                .between("age", 18, 50)
                .eq("last_name", "Tom")
                .eq("gender", 1)
        );


//        需求2：我们需要查询 tbl_employee 表中，性别为女性且名字中带有"老师"或者邮箱中带有 "a"
//        List<Employee> employees = employeeMapper.selectList(new EntityWrapper<Employee>()
//                .eq("gender", 0)
//                .like("last_name", "老师")
////                .or()   // sql:(gender=? and last_name like ? or email like ?)  二者的sql语句存在区别
//                .orNew()   // sql: (gender=? and last_name like ?) or (email like ?)
//                .like("email", "a")
//        );


//        3.需求：查询所有的员工数据，按照age进行降序排序
//        List<Employee> employees = employeeMapper.selectList(new EntityWrapper<Employee>()
////                .orderBy("age")   // 默认使用的是升序排序
////                .orderAsc(Arrays.asList("age"))   // 升序排序需要传入一个集合
//              .orderDesc(Arrays.asList("age"))   // 同样降序也需要传入一个集合
//        );

        for (Employee employee : employees) {
            System.out.println("employee = " + employee);
        }
    }
}
















