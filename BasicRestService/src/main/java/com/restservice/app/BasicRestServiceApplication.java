package com.restservice.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "com.restservice.controller", "com.restservice.model", "com.restservice.service",
		"com.restservice.serviceimpl", "com.restservice.repo","com.restservice.dao" })
@Configuration
@EnableAutoConfiguration
@EntityScan("com.restservice.model")
@EnableJpaRepositories("com.restservice.repo")
public class BasicRestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicRestServiceApplication.class, args);
	}

}
