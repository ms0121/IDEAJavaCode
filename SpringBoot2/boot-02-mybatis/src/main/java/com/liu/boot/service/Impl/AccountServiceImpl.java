package com.liu.boot.service.Impl;

import com.liu.boot.mapper.AccountMapper;
import com.liu.boot.model.Account;
import com.liu.boot.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lms
 * @date 2021-05-20 - 23:38
 */

@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;

    @Override
    public Account selectByPrimaryKey(Integer id) {
        Account account = accountMapper.selectByPrimaryKey(id);
        return account;
    }
}
