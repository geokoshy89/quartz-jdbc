package com.geo.quartz_jdbc.controller;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateScheduler {

  @Autowired
  Scheduler scheduler;
  @GetMapping("/update")
  public ResponseEntity<String> greetings(@RequestParam String cronExpression) {
    try {
      JobDetail jobDetail = scheduler.getJobDetail(JobKey.jobKey("tesjobId2"));
      Trigger trigger = TriggerBuilder.newTrigger()
              .forJob(jobDetail)
              .withIdentity("tesjobId2")
              .withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
              .build();
      scheduler.rescheduleJob(TriggerKey.triggerKey("tesjobId2"), trigger);
    } catch (SchedulerException e) {
      throw new RuntimeException(e);
    }
    return ResponseEntity.ok("Updated the schedule");

  }

}
