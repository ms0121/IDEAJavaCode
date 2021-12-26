package com.liu.config;

import com.liu.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author lms
 * @date 2021-05-07 - 14:38
 * bean的生命周期“
 *      bean创建 --- 初始化 ---- 销毁的过程
 *
 * 容器管理bean的生命周期：
 *      我们可以自定义初始化和销毁的方法，容器在bean进行得到当前生命周期的时候来调用我们自定义的
 *      初始化和销毁方法
 *      init-method 和 destroy-method
 *
 * 1.创建对象，
 *      单实例：在容器启动的时候创建对象
 *      多实例：在每次获取的时候创建对象
 *
 * BeanPostProcessor.postProcessBeforeInitialization
 * 2.初始化： 对象创建完成，并赋值好，调用初始化方法
 *
 * BeanPostProcessor.postProcessAfterInitialization
 * 3.销毁：
 *      单实例：容器关闭的时候
 *      多实例: 容器不会管理这个bean的销毁操作，可以手动的方式进行销毁
 *
 *
 * 4.指定初始化和销毁的方式：
 *     1) 使用 @Bean(initMethod = "init", destroyMethod = "destroy")
 *     2）通过让bean实现  InitializingBean, DisposableBean实现初始化和销毁的操作
 *     3) 使用JSR250：
         *     @PostConstruct 在bean创建完成并且属性赋值完成，来执行初始化方法
         *     @PreDestroy 在容器销毁bean之前通知我们进行清理的工作
 *     4) BeanPostProcessor【Interface】； bean的后置处理器
 *          在bean的初始化前后进行一些处理工作;
     *          postProcessBeforeInitialization: 在初始化之前工作
     *          postProcessAfterInitialization: 在初始化之后工作
 */
// 标识当前是一个配置类

@ComponentScan("com.liu")
@Configuration
public class MainConfigLife {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Car car(){
        return new Car();
    }
}
