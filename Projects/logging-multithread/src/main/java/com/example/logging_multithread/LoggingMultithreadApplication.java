package com.example.logging_multithread;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class LoggingMultithreadApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(LoggingMultithreadApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(LoggingMultithreadApplication.class);
	}

}
