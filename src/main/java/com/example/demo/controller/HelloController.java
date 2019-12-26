package com.example.demo.controller;

import com.example.demo.service.HelloService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {

    @Resource
    private HelloService helloService;

    @RequestMapping("/hello")
    public String hello(){
        System.out.println("开始调用 task任务："+System.currentTimeMillis());
        helloService.task();

        return "success";
    }

    @RequestMapping("/hello2")
    public String hello2(){
        helloService.task2();

        return "success 2";
    }

    @RequestMapping("/hello3")
    public String hello3(){
        helloService.task3();

        return "success 3";
    }
}
