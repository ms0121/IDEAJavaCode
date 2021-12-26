package com.liu.crud.test;

import com.github.pagehelper.PageInfo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

/**
 *
 * 使用spring测试模块提供的测试请求模块，测试curd请求的正确性
 * @author lms
 * 这里主要做了一些修改的部分信息框
 * @date 2021-04-20 - 10:18
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration  // 引入ioc自身的注解
@ContextConfiguration(locations = {"classpath:applicationContext.xml",
        "file:src/main/webapp/WEB-INF/dispatcherServlet-servlet.xml"})

public class CRUDTest {

    // 传入springmvc的ioc
    @Autowired
    WebApplicationContext context;

    // 虚拟MVC请求，获取到处理结果
    MockMvc mockMvc;

    // 每次使用的时候都进行初始化的操作
    @Before
    public void initMockvc() {
        mockMvc =  MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testPage() throws Exception {
        // 模拟发送请求拿到返回值信息,参数表示从第几页开始
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/emps").param("pn", "5")).andReturn();
        // 请求成功之后，查询会将数据放入请求域中，因此请求域中会有pageInfo的信息，我们就可以去除pageInfo进行验证
        MockHttpServletRequest request = result.getRequest();
        PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
        System.out.println("当前页码: " + pageInfo.getPageNum());
        System.out.println("总页码: " + pageInfo.getPages());
        System.out.println("总记录数: " + pageInfo.getTotal());
        System.out.println("在页面需要连续显示的页码");
        int[] nums = pageInfo.getNavigatepageNums();
        for (int num : nums) {
            System.out.println("num = " + num);
        }
        // 获取封装在pageInfo中的员工数据信息
        List employees = pageInfo.getList();
        for (int i = 0; i < 3; i++) {
            System.out.println(employees.get(i));
        }
    }
}












