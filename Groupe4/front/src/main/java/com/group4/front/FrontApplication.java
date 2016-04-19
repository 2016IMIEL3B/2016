package com.group4.front;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "com.group4.front.dao")
@EntityScan(basePackages = {"com.group4.front.entities"})
public class FrontApplication {
/*
	public static void main(String[] args) {
		SpringApplication.run(FrontApplication.class, args);
	}
	*/
}
