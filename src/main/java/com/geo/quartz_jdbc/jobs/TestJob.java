package com.geo.quartz_jdbc.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

@Component
public class TestJob implements Job {

  @Override
  public void execute(JobExecutionContext context) {
    System.out.println("Scheduled job is running for job with new change" + context.getJobDetail().getKey()+ " "+ context.getScheduledFireTime());
  }

}
