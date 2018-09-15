package com.example.springbootdemo;

import com.example.springbootdemo.applicationListener.MyApplicationListener;
import com.example.springbootdemo.listener.MyApplicationEnvironmentPreparedListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDemoApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication();
        springApplication.setWebApplicationType(WebApplicationType.SERVLET);
        springApplication.addListeners(new MyApplicationEnvironmentPreparedListener());
        springApplication.run(SpringBootDemoApplication.class, args);
    }
}
