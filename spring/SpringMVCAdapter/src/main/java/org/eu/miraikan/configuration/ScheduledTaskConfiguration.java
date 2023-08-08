package org.eu.miraikan.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.ScheduledThreadPoolExecutor;

@Configuration
public class ScheduledTaskConfiguration implements SchedulingConfigurer {

    //TaskScheduler has different implementations, including DefaultManagedTaskScheduler and ThreadPoolTaskScheduler
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {

        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor =
                new ScheduledThreadPoolExecutor(0,Thread.ofVirtual().factory());

        ConcurrentTaskScheduler concurrentTaskScheduler = new ConcurrentTaskScheduler(scheduledThreadPoolExecutor);

   taskRegistrar.setScheduler(concurrentTaskScheduler);


    }
}
