package com.atif;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class SchedulerExample {
    public static void main(String[] args) {
        System.out.println("Hi scheduler");

        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
                    .withIdentity("My Job", "group1")
                    .build();
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("trigger1", "group1")
                    .withSchedule(CronScheduleBuilder.cronSchedule("0 * * * * ?"))
                    .build();

            scheduler.scheduleJob(jobDetail, trigger);
            scheduler.start();
//            scheduler.shutdown();
        } catch (SchedulerException schedulerException) {
            System.out.println(schedulerException);
        }

    }
}
