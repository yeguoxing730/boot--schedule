package com.example.demo.controller;

import com.example.demo.job.HelloJob;
import com.example.demo.job.NewJob;
import org.quartz.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by yeguo on 2018/6/6.
 */
//https://blog.csdn.net/zahngjialiang/article/details/78690932
@Controller
public class QuartzMultiController {
    @Resource(name="multitaskScheduler")
    private Scheduler scheduler2;

    @ResponseBody
    @RequestMapping("/multitask")
    public String multitask() throws SchedulerException {
        scheduleJob2(scheduler2);

        return "多任务";

    }

    @ResponseBody
    @RequestMapping("/multitask2")
    public String multitask2() throws SchedulerException {
        scheduleJob(scheduler2);

        return "这个也是多任务";

    }


    //具体的定时任务

    private void scheduleJob2(Scheduler scheduler) throws SchedulerException{
        //配置定时任务对应的Job，这里执行的是ScheduledJob类中定时的方法
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class) .withIdentity("job2", "group1").build();
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/3 * * * * ?");
        // 每3s执行一次
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger2", "group1") .withSchedule(scheduleBuilder).build();
        scheduler.scheduleJob(jobDetail,cronTrigger);
    }

    private void scheduleJob(Scheduler scheduler) throws SchedulerException{
        //配置定时任务对应的Job，这里执行的是ScheduledJob2类中定时的方法
        JobDetail jobDetail = JobBuilder.newJob(NewJob.class) .withIdentity("job1", "group1").build();
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/6 * * * * ?");
        // 每6s执行一次
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1") .withSchedule(scheduleBuilder).build();
        scheduler.scheduleJob(jobDetail,cronTrigger);
    }

}
