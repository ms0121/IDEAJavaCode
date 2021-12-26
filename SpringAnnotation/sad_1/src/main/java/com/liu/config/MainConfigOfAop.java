package com.liu.config;

import com.liu.aop.LogAspects;
import com.liu.aop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author lms
 * @date 2021-05-08 - 9:48
 *
 * AOP:[底层是动态代理的方式 ]
 *     面向切面：指在程序运行期间动态的将某段代码切入到指定方法指定的位置进行运行的编程方式。
 *
 *1.导入aop模块，spring aop：使用的是是spring-aspects的依赖包
 *2.定义一个业务逻辑类（MathCalculator）：在业务逻辑运行的时候，将日记进行打印
 *                                  （方法之前，方法之后，运方法行结束，方法运行异常）
 *3.定义一个日记切面类（LogAspects），切面类里面的方法需要动态感知MathCalculator.div运行到哪里，然后执行。
 *      aop的通知方法：
 *          前置通知(@Before)：logStart，在目标方法（div）运行之前执行
 *          后置通知(@After)：logEnd，在目标方法（div）运行之后执行，无论是否正常结束还是异常结束
 *          返回通知(@AfterReturning)：logReturn，在目标方法（div）正常返回后执行
 *          异常通知(@AfterThrowing)：logException，在目标方法（div）出现异常后执行
 *          环绕通知(@Around)：动态代理，手动推进目标方法运行(JoinPoint.procced())
 *4.给切面类的目标方法标注何时何地运行（通知注解）
 *5.将切面类和业务逻辑类(目标方法类)都加入到容器中
 *6。必须告诉spring哪个类是切面类(给切面类加上一个注解，@Aspect)
 *7.最重要：给配置类中加入 @EnableAspectJAutoProxy 【开启基于注解的aop模式】
 *
 */
// 注明当前的类是一个配置类（相当于配置文件）
@EnableAspectJAutoProxy
@Configuration
public class MainConfigOfAop {

    // 将切面类加入到ioc容器中
    @Bean
    public LogAspects logAspects(){
        return new LogAspects();
    }

    // 将业务逻辑类加入到容器中
    @Bean
    public MathCalculator mathCalculator(){
        return new MathCalculator();
    }

}
