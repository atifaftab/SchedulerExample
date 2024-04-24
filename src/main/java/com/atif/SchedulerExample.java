package com.atif;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

public class SchedulerExample {
    public static void main(String[] args) {
        System.out.println("Hi scheduler");

        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();
            scheduler.shutdown();
        } catch (SchedulerException schedulerException) {
            System.out.println(schedulerException);
        }

    }
}
