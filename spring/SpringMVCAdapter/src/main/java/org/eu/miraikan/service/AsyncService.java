package org.eu.miraikan.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {
    @Async
    public void service(){
        System.out.println("async service on virtualThread "+Thread.currentThread().isVirtual());
    }
}
