package com.liu.ba01;

import org.springframework.stereotype.Component;

/**
 * @author lms
 * @date 2021-04-25 - 18:17
 *
 *
 * @Component: 创建对象的，等同于基于xml方式的<bean>的功能，
 * 属性：value就是对象的名称，也就是bean的id值
 *      value的值也是唯一的，创建的对象在整个spring容器中就只有一个
 * 位置：放在类的上面
 *
 * @Component(value = "myStudent")等同于：
 *  <bean id="myStudent" class="com.liu.ba01.Student" />
 *
 *  spring中和 @Component功能一致，创建对象的注解还有：
 * @Repository（用在持久层的上面）: 放在dao的实现类上面，表示创建dao对象，dao对象是能访问数据库的
 * @Service（用在业务层类的上面）： 放在service的实现类的上面，创建service对象，service对象
 *                                  是做业务处理，可以有事务功能的处理
 * @Controller(用在控制器的上面)： 放在控制器（处理器）类的上面，创建控制器对象的，控制器对象，
 *                                能够接受用户提交的参数，显示请求的处理结果
 *  以上三个注解的使用方法和@component一样，都能创建对象，但是这三个注解还有额外的功能，
 *  @Repository,@Service,@Controller是给项目的对象分层的
 */

//使用value属性，指定对象名称
//@Component(value = "myStudent")

// 省略value属性
//@Component("myStudent")

// 不指定对象名称，由spring提供默认名称：类名首字母小写
@Component
public class Student {

    private String name;
    private int age;

    public Student() {
        System.out.println("=========无参构造器==========");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
