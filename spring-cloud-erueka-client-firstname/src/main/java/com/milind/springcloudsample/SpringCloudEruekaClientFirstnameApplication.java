package com.milind.springcloudsample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudEruekaClientFirstnameApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEruekaClientFirstnameApplication.class, args);
	}
}
