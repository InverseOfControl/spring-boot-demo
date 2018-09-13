package com.example.springbootdemo.controller;

import com.example.springbootdemo.applicationListener.MyApplicationEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private ApplicationEventPublisher publisher;

    @Value("${aaa}")
    private String str;

    @Autowired
    private StringRedisTemplate redisTemplate1;

    @GetMapping("/demo")
    public void demo(){
        publisher.publishEvent(new MyApplicationEvent("测试123"));
    }
}
