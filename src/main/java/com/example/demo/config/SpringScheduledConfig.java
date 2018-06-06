package com.example.demo.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * Created by yeguo on 2018/6/6.
 */
@Component
public class SpringScheduledConfig {
    public final static long SECOND = 1 * 1000;

//固定等待时间 @Scheduled(fixedDelay = 时间间隔 ) one
    @Scheduled(fixedDelay = SECOND * 2)
    public void fixedDelayJob() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        System.out.println("[FixedDelayJob Execute]"+ LocalDateTime.now());
    }
//固定间隔时间 @Scheduled(fixedRate = 时间间隔 ) two
    @Scheduled(fixedRate = SECOND * 4)
    public void fixedRateJob() {
        System.out.println("[FixedRateJob Execute]"+LocalDateTime.now());
    }
//Corn表达式 @Scheduled(cron = Corn表达式) three

    @Scheduled(cron = "0/4 * * * * ?")
    public void cronJob() {
        System.out.println("[CronJob Execute]"+LocalDateTime.now());
    }

}
