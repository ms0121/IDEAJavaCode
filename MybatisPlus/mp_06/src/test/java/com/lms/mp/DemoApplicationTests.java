package com.lms.mp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lms.mp.entity.User;
import com.lms.mp.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.processor.ObjectRowListProcessor;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Resource
    private UserMapper userMapper;

    // 查询多个指定id的user信息
    @Test
    public void testSelect2(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "张三");
        map.put("age", 25);
        List<User> users = userMapper.selectByMap(map);
        System.out.println("users = " + users);
    }


    // 查询多个指定id的user信息
    @Test
    public void testSelect1(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        System.out.println("users = " + users);
    }



    /**
     * 测试乐观锁，执行修改操作，version版本号会自动进行加 1 的操作
     */
    @Test
    public void testOptimisticLocker(){
        // 1.查询用户信息
        User user = userMapper.selectById(1415961990392299522L);
        user.setName("卫庄");
        // 2. 执行修改操作
        userMapper.updateById(user);
    }



    @Test
    public void updateTest(){
        User user = new User();
        user.setId(1415961990392299522L);
        user.setName("卫庄");
        user.setAge(19);
        user.setEmail("213@qq.com");
        int i = userMapper.updateById(user);
        System.out.println("i = " + i);

    }

    // 执行单个删除的操作
    @Test
    public void testDelete(){
        int flag = userMapper.deleteById(1416007289176944642L);
        System.out.println("flag = " + flag);
    }


    @Test
    public void insertTest(){
        User user = new User();
        user.setName("红莲");
        user.setAge(18);
        user.setEmail("121@qq.com");
        int insert = userMapper.insert(user);
        System.out.println("insert = " + insert);
    }

    // 查询到的操作
    @Test
    public void testSelect(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        ge,gt.lt,le
//        queryWrapper.ge("age", 23);

//        区间范围
//        queryWrapper.between("age", 18,23);

//        模糊查询
        queryWrapper.like("name", "J");

        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println("users = " + users);
    }



    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        System.out.println("users = " + users);
    }


    /**
     * 实现分页的条件:
     *    1. 必须有配置类（即配置分页插件xml信息）
     *    2.编写分页代码
     *          ①创建Page对象，传入两个参数（当前页，每页显示的记录数）
     *          ②调用mp的方法实现分页
     */
    @Test
    public void page(){
        Page<User> page = new Page<>(1, 3);
        IPage<User> userIPage = userMapper.selectPage(page, null);
        // 从返回对象中获取分页的所有数据信息
        long pages = userIPage.getPages();
        List<User> records = userIPage.getRecords();
        long current = userIPage.getCurrent();
        System.out.println("pages = " + pages);
        System.out.println("records = " + records);
        System.out.println("current = " + current);
    }













}
