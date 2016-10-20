/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FavoritesCleanupTimer;

/**
 *
 * @author Darrens
 */
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzListener implements ServletContextListener {
        Scheduler scheduler = null;

        @Override
        public void contextInitialized(ServletContextEvent servletContext) {
            
            System.out.println("Context Initialized");
            try {
                        // Setup the Job class and the Job group
                        JobDetail job = newJob(QuartzJob.class).withIdentity(
                                        "Job", "Group").build();

                        
                        //SimpleTrigger – Run every 10 seconds.
                        Trigger trigger = newTrigger().withIdentity("TriggerName", "Group")
                        .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInMinutes(5).repeatForever()).build();
                        //.withIntervalInHours(24*7).repeatForever()).build(); //SET to once a week after debugging
                        

                        // Setup the Job and Trigger with Scheduler & schedule jobs
                        scheduler = new StdSchedulerFactory().getScheduler();
                        scheduler.start();
                        scheduler.scheduleJob(job, trigger);
                }
                catch (SchedulerException e) {
                        e.printStackTrace();
                }

        }

        @Override
        public void contextDestroyed(ServletContextEvent servletContext) {
                System.out.println("Context Destroyed");
                try 
                {
                        scheduler.shutdown();
                } 
                catch (SchedulerException e) 
                {
                        e.printStackTrace();
                }
        }
}