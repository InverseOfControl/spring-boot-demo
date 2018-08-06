package com.example.springbootdemo;

import com.example.springbootdemo.listener.MyApplicationEnvironmentPreparedListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringBootDemoApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication();
        springApplication.addListeners(new MyApplicationEnvironmentPreparedListener());
        springApplication.run(SpringBootDemoApplication.class, args);
    }
}
