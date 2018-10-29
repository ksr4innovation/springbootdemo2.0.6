package com.snkit.springbooteurekaserverdr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringbooteurekaserverdrApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbooteurekaserverdrApplication.class, args);
	}
}
