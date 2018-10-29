package com.snkit.springbootsepteurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringbootsepteurekaserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootsepteurekaserverApplication.class, args);
	}
}
