package com.liu.boot.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.liu.boot.mapper.AccountMapper;
import com.liu.boot.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author lms
 * @date 2021-05-23 - 22:48
 */

@Component
@Service(interfaceClass = AccountService.class, version = "1.0.0")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Override
    public Account queryAccount(Integer id) {
        Account account = accountMapper.selectByPrimaryKey(id);
        return account;
    }

    /**
     *使用redis的方式优先从缓存中查找数据信息，目的：提升系统的性能，提升用户体验
     * 首先去Redis缓存中查询数据，如果有直接使用，没有再去数据库中查询，然后将数据存放在缓存中
     */
    @Override
    public Integer queryAllAccountCount() {

        Integer count = (Integer) redisTemplate.opsForValue().get("allAccountCount");

        // 判断是否有值
        if (null == count){
            // 去数据库中查询数据
            count = accountMapper.queryAllAccountCount();
            // 把查询的数据存放在Redis缓存中，并设置有效的时间
            redisTemplate.opsForValue().set("allAccountCount", count, 30, TimeUnit.SECONDS);
        }
        return count;
    }
}
