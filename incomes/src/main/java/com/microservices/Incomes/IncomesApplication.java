package com.microservices.Incomes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class IncomesApplication {

	public static void main(String[] args) {
		SpringApplication.run(IncomesApplication.class, args);
	}

}
