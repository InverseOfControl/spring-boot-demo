package com.example.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Value("${aaa}")
    private String str;

    @Value("${bbb}")
    private String bbb;

    @Autowired
    private StringRedisTemplate redisTemplate1;

    @GetMapping("/demo")
    public String demo(){
        return str;
    }
}
