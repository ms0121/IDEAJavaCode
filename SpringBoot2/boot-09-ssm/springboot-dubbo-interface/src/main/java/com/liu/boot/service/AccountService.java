package com.liu.boot.service;

import com.liu.boot.model.Account;

/**
 * @author lms
 * @date 2021-05-23 - 22:47
 */
public interface AccountService {

    Account queryAccount(Integer id);

    Integer queryAllAccountCount();

}
