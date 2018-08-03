package com.example.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.env.PropertiesPropertySourceLoader;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {

		SpringApplication springApplication = new SpringApplication();
		springApplication.addListeners(new MyListener());
		springApplication.run(SpringBootDemoApplication.class, args);

	}
}

class MyListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

	private final PropertiesPropertySourceLoader loader = new PropertiesPropertySourceLoader();

	@Override
	public void onApplicationEvent(ApplicationEnvironmentPreparedEvent applicationEnvironmentPreparedEvent) {
		System.out.println("==================================");
		ConfigurableEnvironment configurableEnvironment = applicationEnvironmentPreparedEvent.getEnvironment();
		MutablePropertySources mutablePropertySources = configurableEnvironment.getPropertySources();
		PropertySource propertySource = null;
		try {
			propertySource = loader.load("123", new ClassPathResource("test.properties")).get(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
		mutablePropertySources.addFirst(propertySource);
	}
}
