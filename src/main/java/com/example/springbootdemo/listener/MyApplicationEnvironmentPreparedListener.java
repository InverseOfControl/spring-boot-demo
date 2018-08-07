package com.example.springbootdemo.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.env.PropertiesPropertySourceLoader;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * ${@link ApplicationListener}
 * ${@link} ApplicationEnvironmentPreparedEvent
 * 在springboot启动的时候，通过ApplicationEnvironmentPreparedEvent可以加载自定义的配置文件变量
 * 此文件配置在META-INF的spring.factories中，在springboot启动的时候会自动加载到spring中
 */
public class MyApplicationEnvironmentPreparedListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {
    private static final Logger logger = LoggerFactory.getLogger(MyApplicationEnvironmentPreparedListener.class);

    //Properties文件的属性加载器
    private final PropertiesPropertySourceLoader loader = new PropertiesPropertySourceLoader();

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent applicationEnvironmentPreparedEvent) {
        System.out.println("MyApplicationEnvironmentPreparedEvent load begin");
        //通过ConfigurableEnvironment可以自行配置环境属性，通过Configurable修改的类，代表可扩展
        ConfigurableEnvironment configurableEnvironment = applicationEnvironmentPreparedEvent.getEnvironment();
        MutablePropertySources mutablePropertySources = configurableEnvironment.getPropertySources();
        PropertySource propertySource = null;


        for (Iterator<PropertySource<?>> it = mutablePropertySources.iterator(); it.hasNext(); ) {
            PropertySource propertySource1 = it.next();
            if("applicationConfig: [classpath:/application.properties]".equals(propertySource1.getName())){
                System.out.println(propertySource1.getProperty("server.port"));
            }
        }


        try {
            propertySource = loader.load("myProperties", new ClassPathResource("test.properties")).get(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        mutablePropertySources.addFirst(propertySource);
    }
}
