package com.chuwa.redbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class RedbookApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedbookApplication.class, args);
	}

}
