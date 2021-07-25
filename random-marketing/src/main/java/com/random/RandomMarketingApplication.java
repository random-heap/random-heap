package com.random;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class RandomMarketingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RandomMarketingApplication.class, args);
	}
	
}
