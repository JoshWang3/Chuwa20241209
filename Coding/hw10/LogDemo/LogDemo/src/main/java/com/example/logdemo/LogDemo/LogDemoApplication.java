package com.example.logdemo.LogDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.logdemo")
public class LogDemoApplication extends SpringBootServletInitializer {

/*
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(YourApplication.class);
	}
*/
	public static void main(String[] args) {
		SpringApplication.run(LogDemoApplication.class, args);
	}

}
