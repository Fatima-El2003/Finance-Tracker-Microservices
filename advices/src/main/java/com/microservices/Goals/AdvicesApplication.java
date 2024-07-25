package com.microservices.Goals;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AdvicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvicesApplication.class, args);
	}

}
