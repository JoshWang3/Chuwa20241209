package com.example.logdemo.LogDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.logdemo")
public class LogDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogDemoApplication.class, args);
	}

}
