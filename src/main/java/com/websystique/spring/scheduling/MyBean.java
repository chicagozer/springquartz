package com.websystique.spring.scheduling;

import java.util.Date;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import static org.quartz.TriggerBuilder.newTrigger;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.stereotype.Component;

@Component("myBean")
public class MyBean {

    @Autowired
    private Scheduler scheduler;

    @Autowired 
    @Qualifier("thirdJobDetail")
    MethodInvokingJobDetailFactoryBean thirdjob;

    public void printMessage() throws ClassNotFoundException, SchedulerException, NoSuchMethodException {
        System.out.println("I am called by MethodInvokingJobDetailFactoryBean using SimpleTriggerFactoryBean");

        for (int i = 0; i < 5; i++) {
           
            
              SimpleTrigger trigger = (SimpleTrigger) newTrigger()
                    .startAt(new Date())
                    .forJob(thirdjob.getObject())
                    .build();

        // And drop it into the scheduler for immediate execution
        scheduler.scheduleJob(trigger);
        }

    }

}
