package com.liu.boot.config;

import com.liu.boot.bean.Pet;
import com.liu.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @author lms
 * @date 2021-05-16 - 10:02
 */
@Configuration  // 标识当前的类是一个配置类，等同于以前的配置文件（bean.xml）的方式
//@ConditionalOnMissingBean(name = "pet") // 容器中不存在当前的pet组件，当前的这个配置类生效
//@ConditionalOnBean(name = "pet") // 容器中存在pet组件，这个配置类才会生效
//@ImportResource("classpath:bean.xml") // 直接使用原生的配置文件的方式给属性进行赋值
//@Import({User.class, Pet.class})  // @Import 表示把当前的两个类添加到配置类中，由配置类注入到容器中
//@Import({User.class, Pet.class})使用之后，不可以在配置类的下面再次进行组件的注入，要求组件单实例，@Import就是给容器导入组件
public class MyConfig {

    /**
     * 将当前的user组件添加到容器中（等于(bean.xml中的bean)）,方法的名字默认等于组件在容器中的名字，也可以使用
     * Bean的name属性进行设置，返回值类型就是组件的类型
     *
     *  @ConditionalOnBean(name = "pet"):容器中存在pet组件，就将user1组件添加到容器中
     *  @ConditionalOnMissingBean(name = "pet"):容器中不存在pet组件，就将user1组件添加到容器中
     *  放在里面代表的是局部的影响
     */
//    @ConditionalOnBean(name = "pet")
//    @ConditionalOnMissingBean(name = "pet")
    @Bean
    public User user1(){
//        User user = new User();
//        user.setName("张三");
//        user.setAge(20);
//        return user;
        return new User();
    }

    /**
     * 默认容器中使用的组件都是单实例的，如果使用了配置文件bean.xml的方式记性注入，配置类中的这个bean就不能再次进行注入容器，会出错
      * @return
     */
//    @Bean
//    public Pet pet1(){
//        return new Pet();
//    }

}
