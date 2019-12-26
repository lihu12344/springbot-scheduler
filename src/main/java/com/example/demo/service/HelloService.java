package com.example.demo.service;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Duration;
import java.time.Instant;

@Service
public class HelloService {

    @Resource
    private TaskScheduler taskScheduler;

    public void task(){
        taskScheduler.scheduleWithFixedDelay(()->{
            System.out.println("task开始执行："+System.currentTimeMillis());
        }, Instant.now().plusSeconds(10), Duration.ofSeconds(5));
    }

    @Scheduled(initialDelay = 10,fixedDelay = 5)
    public void task2(){
        System.out.println("task2 开始执行："+System.currentTimeMillis());

        try{
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("task2 运行结束："+System.currentTimeMillis());
    }

    @Scheduled(cron = "1/10 * * * * ?")
    public void task3(){
        System.out.println("task3 开始执行："+System.currentTimeMillis());

        try{
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("task3 运行结束："+System.currentTimeMillis());
    }
}
