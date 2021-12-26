package com.liu.config;

import com.liu.bean.Color;
import com.liu.bean.ColorFactoryBean;
import com.liu.bean.Person;
import com.liu.bean.Red;
import com.liu.condition.LinuxCondition;
import com.liu.condition.MyImportSelector;
import com.liu.condition.WindowCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author lms
 * @date 2021-05-07 - 11:14
 *
 * 配置类同样可以设置像配置文件bean.xml中的属性一样
 *  1.scope：用于配置当前的bean是否是单/多实例
 *      单实例：前后创建的对象都是同一个
 *      多实例：每次创建的对象都是不同的，（hascode值不一样）
 *      prototype：多实例：ioc容器启动并不会去调用方法创建对象放置在容器中
 *                  而是每次获取的时候才去调用方法创建对象
 *      singleton：单实例（默认使用）：ioc容器启动的时候会去调用方法创建对象
 *                  放到ioc容器中，以后每次获取就是直接从容器中获取
 *                  lazy懒加载：默认在容器启动的时候创建对象
 *      request：同一次请求创建一个实例
 *      session：同一个session创建一个实例
 */

@Configuration
//@Import(Color.class)
@Import({Color.class, Red.class, MyImportSelector.class})
public class MainConfig2 {

//    @Scope("prototype")
//    @Lazy
    @Bean("person")
    public Person person(){
//        System.out.println("给容器中添加Person..........");
        return new Person("利路修", 26);
    }

    /**
     * @Conditional({Condition}),按照一定的条件进行判断，满足条件
     *  给容器中注册bean对象，(动态的给容器中添加bean对象)
     *  如果系统是window，给容器注册 person1
     *  linux的就注册person2
     * @return
     */
    // 类中组件统一设置，满足这个当前条件，这个类中配置的所有bean组件才能生效
    @Conditional(WindowCondition.class)
    @Bean("person1")
    public Person person1(){
        return new Person("李四", 20);
    }

    @Conditional(LinuxCondition.class)
    @Bean("person2")
    public Person person2() {
        return new Person("张三", 19);
    }


    /**
     * 给容器中注册组件的方式：
     *      1. 包扫描 + 组件标注注解(@Controller @Service @Repository @Component)
     *      2.@Bean(导入第三方包中的组件)
     *      3.@Import(快速给容器中导入(注入bean对象)一个组件)
     *          1）.@Import（要导入到容器中的组件），容器中就会自动注册这个组件，id默认是全类名
     *          2）.ImportSelector：返回需要的导入的组件的全类名数组
     *          3）.ImportBeanDefinitionRegister：手动注册Bean的方式
     *     4.使用spring提供的FactoryBean（工厂Bean)
     *          1)默认获取到的是工厂bean调用getObject方法创建的对象
     *          2)要获取工厂bean的本身，我们需要给id的前面添加&符号，即：&colorFactoryBean
     */

    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }

}
