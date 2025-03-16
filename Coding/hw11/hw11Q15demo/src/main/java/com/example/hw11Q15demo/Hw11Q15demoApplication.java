package com.example.hw11Q15demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Hw11Q15demoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Hw11Q15demoApplication.class, args);
	}

	@Bean
	public MessageService messageService() {
		return new MessageService("Hello, this is Hw11Q15demoApplication.");
	}

	@Bean
	public BeanService beanService() {
		return new BeanService();
	}
}
