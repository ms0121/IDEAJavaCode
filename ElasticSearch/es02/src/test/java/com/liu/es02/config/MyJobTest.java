package com.liu.es02.config;

import com.liu.es02.job.MyJob;
import org.junit.jupiter.api.Test;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.SimpleTriggerImpl;

/**
 * @author lms
 * @date 2021-10-27 - 20:42
 */
class MyJobTest {

    @Test
    public void test01() throws SchedulerException {
        // 创建一个任务
        JobDetailImpl jobDetail = new JobDetailImpl("myJOb", "group", MyJob.class);
        // 创建一个简单的触发器，实现每隔2秒执行一次
        SimpleTrigger simpleTrigger = new SimpleTriggerImpl("trigger", 10,2000);

        // 创建一个调度器
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        // 调度任务
        scheduler.scheduleJob(jobDetail, simpleTrigger);
        // 启动任务调度器
        scheduler.start();
        scheduler.shutdown();
    }
}
