package com.example.demo.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by yeguo on 2018/6/6.
 */
public interface BaseJob extends Job {
    public void execute(JobExecutionContext context) throws JobExecutionException;

}
