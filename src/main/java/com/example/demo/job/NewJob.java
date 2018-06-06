package com.example.demo.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * Created by yeguo on 2018/6/6.
 */
public class NewJob implements BaseJob {


    public NewJob() {

    }

    public void execute(JobExecutionContext context)
            throws JobExecutionException {
       System.out.println("New Job执行时间: " + new Date());

    }

}
