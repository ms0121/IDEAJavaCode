package com.liu;

import com.liu.config.MainConfigOfAop;
import com.liu.tx.TxConfig;
import com.liu.tx.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lms
 * @date 2021-05-08 - 11:54
 */
public class tx_MainConfigTx {

    @Test
    public void test1() {
        // 将所有的组件加入到ioc容器中
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(TxConfig.class);
        // 从容器中获取指定的类型的bean对象
        UserService userService = context.getBean(UserService.class);
        userService.insertUser();
    }
}
