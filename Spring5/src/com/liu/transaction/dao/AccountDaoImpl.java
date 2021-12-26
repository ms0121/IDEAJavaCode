package com.liu.transaction.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author lms
 * @date 2021-04-12 - 17:09
 */

@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired // 实现自动注入
    private JdbcTemplate jdbcTemplate;


    @Override
    public void addMoney() {
        String sql = "update t_account set money = money + ? where username=?";
        jdbcTemplate.update(sql, 100, "mary");
    }

    @Override
    public void reduceMoney() {
        String sql = "update t_account set money = money - ? where username=?";
        jdbcTemplate.update(sql, 100, "lucy");
    }
}
