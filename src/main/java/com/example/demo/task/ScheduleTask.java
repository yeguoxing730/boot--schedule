package com.example.demo.task;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

/**
 * Created by yeguo on 2018/6/6.
 */
@Configuration
@Component
@EnableScheduling // 该注解必须要加
public class ScheduleTask {
    public void scheduleTest() {
        System.err.println("scheduleTest开始定时执行");
    }

}
