package com.geo.quartz_jdbc.configuration;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.geo.quartz_jdbc.jobs.TestJob;

@Configuration
public class QuartzConfig {
  @Bean
  public JobDetail jobDetail() {
    return JobBuilder.newJob(TestJob.class)
        .withIdentity("tesjobId2")
        .storeDurably()
        .build();
  }

  @Bean
  public Trigger trigger(JobDetail jobDetail) {
    return TriggerBuilder.newTrigger()
        .forJob(jobDetail)
        .withIdentity("tesjobId2")
        .withSchedule(CronScheduleBuilder.cronSchedule("*/3 * * * * ?"))
        .build();
  }

}
