package org.eu.miraikan.controller;

import org.eu.miraikan.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    AsyncService asyncService;

    @GetMapping("/test")
    public void test(){


        System.out.println("handle request on virtualThread "+Thread.currentThread().isVirtual());

    }

    @GetMapping("/test1")
    public void test1(){
        new Thread(()->{
            System.out.println("a platform thread " + !Thread.currentThread().isVirtual());
        }).start();
    }

    @GetMapping("/test2")
    public void test2(){


        asyncService.service();
    }
}
