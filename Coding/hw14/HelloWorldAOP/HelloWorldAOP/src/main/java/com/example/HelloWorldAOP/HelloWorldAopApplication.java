package com.example.HelloWorldAOP;

import com.external.ExternalService;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class HelloWorldAopApplication {
	@Autowired
	private ExternalService externalService;

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldAopApplication.class, args);
	}

	@PostConstruct
	public void triggerAOP() {
		externalService.externalMethod();
	}

}
