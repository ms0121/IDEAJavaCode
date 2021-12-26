package com.liu.mp.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.liu.mp.beans.Employee;

/**
 * @author lms
 * @date 2021-05-05 - 21:28
 */
/**
 * Mapper（dao）接口
 *
 * 基于Mybatis:  在Mapper（dao）接口中编写CRUD相关的方法  提供Mapper（dao）接口所对应的 SQL映射文件（xml） 以及方法对应的SQL语句.
 *
 * 基于MP:  让XxxMapper（XXXDao）接口继承 BaseMapper接口即可.
 * 		   BaseMapper<T> : 泛型指定的就是当前Mapper接口所操作的实体类类型
 *
 */
public interface EmployeeMapper extends BaseMapper<Employee> {
    //   Integer  insertEmployee(Employee employee );
    //   <insert useGeneratedKeys="true" keyProperty="id" > SQL...</insert>
}
