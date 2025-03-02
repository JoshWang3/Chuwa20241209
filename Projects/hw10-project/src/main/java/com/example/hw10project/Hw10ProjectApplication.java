package com.example.hw10project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class Hw10ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(Hw10ProjectApplication.class, args);
	}

}
