package com.example.demo.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.logging.Logger;

/**
 * Created by yeguo on 2018/6/6.
 */
public class HelloJob implements BaseJob {

    private static Logger _log = (Logger) LoggerFactory.getLogger(HelloJob.class);

    public HelloJob() {

    }

    public void execute(JobExecutionContext context)
            throws JobExecutionException {
       System.out.println("Hello Job执行时间: " + new Date());

    }

}
