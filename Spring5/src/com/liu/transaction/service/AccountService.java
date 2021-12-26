package com.liu.transaction.service;

import com.liu.transaction.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lms
 * @date 2021-04-12 - 17:09
 *
 * 事务一般都添加到service层
 * 2 、在 Spring  进行事务管理操作
 *  （1 ）有两种方式：编程式事务管理 和声明式事务管理（使用）
 *
 * 3 、声明式事务管理
 *  （1 ）基于注解方式 （使用）
 * （2）基于 xml 配置文件方式
 *
 * 4 、在 Spring  进行声明式事务管理，底层使用 AOP  原理
 *
 * 5 、在 service  类上面（ 或者 service  类里面方法上面）添加事务注解
     * （1）@Transactional，这个注解添加到类上面，也可以添加方法上面
     * （2）如果把这个注解添加类上面，这个类里面所有的方法都添加事务
     * （3）如果把这个注解添加方法上面，为这个方法添加事务
 */

@Service
@Transactional  // 类里面所有的方法都添加事务
public class AccountService {

    @Autowired  // 自动进行注入
    private AccountDao accountDao;

    // 转账
    public void accountMoney(){

        accountDao.reduceMoney();
        // 所以为了防止因为异常的出现导致转账出现错误，必须添加数据库事务的操作
        // 模拟异常的出现
//        int i = 10 / 0;
        accountDao.addMoney();

    }


}
