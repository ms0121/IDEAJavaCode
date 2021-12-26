package com.liu.es02.config;

import com.liu.es02.job.MyJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lms
 * @date 2021-10-27 - 21:41
 */
@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail jobDetail(){
        return JobBuilder.newJob(MyJob.class) // 表示给哪个任务进行定时
            .withIdentity("DateTimeJob") // 可以给该JobDetail起一个id
            .storeDurably().build();
    }


    @Bean
    public Trigger trigger(){
        // 创建定时任务器
        CronScheduleBuilder schedule = CronScheduleBuilder.cronSchedule("0/1 * * * * ?");
        return TriggerBuilder.newTrigger().
                forJob(jobDetail()) // 表示给哪个jobDetail进行处理
                .withIdentity("quartz01")
                .withSchedule(schedule)
                .build();
    }



}
