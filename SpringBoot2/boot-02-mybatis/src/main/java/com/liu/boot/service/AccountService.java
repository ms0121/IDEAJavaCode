package com.liu.boot.service;

import com.liu.boot.model.Account;

/**
 * @author lms
 * @date 2021-05-20 - 23:36
 */

public interface AccountService {
    Account selectByPrimaryKey(Integer id);
}
