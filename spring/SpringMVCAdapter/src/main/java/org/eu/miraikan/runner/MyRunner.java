package org.eu.miraikan.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class MyRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("runner on virtualThread "+Thread.currentThread().isVirtual());
    }

    @Scheduled(fixedDelay = 10000)
    public void job(){
        System.out.println("scheduled task on virtualThread "+Thread.currentThread().isVirtual());
    }


}
