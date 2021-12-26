package com.liu.es02.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author lms
 * @date 2021-10-27 - 20:41
 */
public class MyJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("这是定时任务，正在执行...........");
        // 可以调用自定义的方法
    }
}
