package com.example.springbootdemo.base;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.ArrayList;

public abstract class ApplicationTaskProcessor implements TaskProcessor, ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Override
    public void doProcess() {
        TaskProcessor processor = (TaskProcessor) applicationContext.getBean("");
        processor.doProcess();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
