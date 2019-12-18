package com.theotherprogrammingblog.springbootservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringBootFulfillmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFulfillmentServiceApplication.class, args);
	}

}
