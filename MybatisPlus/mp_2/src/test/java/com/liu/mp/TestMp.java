package com.liu.mp;

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
 * @date 2021-05-05 - 21:19
 *
 * 当前测试的是使用AR中的Model父类中的方法： 增删改查
 */
public class TestMp {

    private ApplicationContext ioc =
            new ClassPathXmlApplicationContext("applicationContext.xml");


//    AR的分页方法和前面的分页方法不同，该方法直接返回的是一个分页的对象
    @Test
    public void name() {
        Employee employee = new Employee();
        Page<Employee> page = employee.selectPage(new Page<Employee>(1, 2),
                new EntityWrapper<Employee>()
                        .like("email", "com")
        );

        // 获取分页中的所有数据信息
        List<Employee> records = page.getRecords();
        System.out.println("records = " + records);
        System.out.println("====================================");
        int current = page.getCurrent();
        System.out.println("当前页 = " + current);
        long pages = page.getSize();
        System.out.println("每页的size = " + pages);
        long total = page.getTotal();
        System.out.println("total = " + total);
    }



//    AR的删除操作
//    注意：在AR中的删除操作，即使要删除的数据不存在，逻辑上也是正确的，所以最终返回的结果还是true
    @Test
    public void testDeleteAR() {
        Employee employee = new Employee();

//        2.根据条件进行删除操作
        boolean flag = employee.delete(new EntityWrapper<Employee>().like("last_name", "lilux"));
        System.out.println("flag = " + flag);


//        1.根据id进行删除
//        boolean b = employee.deleteById(5);
//        System.out.println("b = " + b);

    }


//    AR的查询操作
    @Test
    public void testSelectAR() {
        Employee employee = new Employee();

//        5.查询数据表中记录总数
//        int count = employee.selectCount(null);
//        System.out.println("count = " + count);


//        4.查询数据表数据的数量
//        int count = employee.selectCount(new EntityWrapper<Employee>().like("gender", "1"));
//        System.out.println("count = " + count);


//        3.查询名字中带有老师的员工信息
//        List<Employee> employees = employee.selectList(new EntityWrapper<Employee>().like("last_name", "老师"));
//        System.out.println("employees = " + employees);


//        2。查询数据表中的所有的数据信息
        List<Employee> employees = employee.selectAll();
        for (Employee employee1 : employees) {
            System.out.println("employee1 = " + employee1);
        }


////        1.直接根据id进行查询
////        Employee employee1 = employee.selectById(10);
//
//        employee.setId(10);
//        Employee employee1 = employee.selectById();
//        System.out.println("employee1 = " + employee1);


    }




//    AR的修改操作
    @Test
    public void testUpdateAR() {
        Employee employee = new Employee();
        employee.setId(10);
        employee.setLastName("隔壁老王");
        employee.setEmail("gebilaowang@126.com");
        employee.setGender(1);
        employee.setAge(20);

        // 直接调用AR中提供的根据id进行修改数据表的
        boolean b = employee.updateById();
        System.out.println("b = " + b);

    }




    // AR的插入操作
    @Test
    public void testInsertAR() {
        Employee employee = new Employee();
        employee.setLastName("李四");
        employee.setEmail("lisigou@qq.com");
        employee.setGender(1);
        employee.setAge(30);

        // 直接调用父类中封装好的增删改查操作
        boolean flag = employee.insert();
        System.out.println("flag = " + flag);
    }


}
