package com.liu.boot.config;

import com.liu.boot.bean.Car;
import com.liu.boot.bean.Pet;
import com.liu.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author lms
 * @date 2021-05-09 - 11:52
 * @Configuration: 配置类
 * 1.配置类里面使用@Bean标注在方法上给容器注册组件，默认是使用单实例
 * 2.配置类本身也是组件
 * 3. proxyBeanMethods = true： 代理bean的方法,
 * 4. @Conditional：条件装配：满足Conditional指定的条件，则进行组件注入
 */
// 告诉SpringBoot这是一个配置类，等同于以前的配置文件

//@Import({})  // 默认导入到容器中的是全类名
@Configuration(proxyBeanMethods = true)
//@ConditionalOnBean(name = "tom")   // 判断容器中存在tom组件，就创建下面类中的组件在容器中
@ConditionalOnMissingBean(name = "tom") // 如果容器中不存在tom组件，则创建类中的组件在容器中
@ImportResource("classpath:beans.xml")  // 导入原生的配置文件方式，让其生效

// 方式2：
@EnableConfigurationProperties(Car.class) //
// 1.开启car配置绑定功能
// 2.把这个Car这个组件自动的注入到容器中，等价于Component的自动自如
public class MyConfig {

    // bean表示：给容器中添加组件，默认是以方法名作为组件的id，返回值类型就是组件类型，
    // 返回的值就是组件在容器中的实例
    // 外部无论对配置类中的这个组件注册方法调用多少次，获取的都是之前在容器中创建的单实例对象
    //    @ConditionalOnBean(name = "tom") // :表示判断当前的容器中是否存在 tom 这个组件，存在则创建user01这个组件在容器中，反之不创建
    @Bean
    public User user01() {
        return new User("zhangsan", 19);
    }

    // 相当于xml配置文件中的id值，给组件进行命名，不直接使用方法名
    //    @ConditionalOnBean(name = "tom")
    @Bean("tom22")
    public Pet tomcatPet() {
        return new Pet("tomcatPet");
    }

    //    @Bean("tom")
    public Pet tom() {
        return new Pet("tomPet");
    }
}
