package com.tedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@SpringBootApplication
@EnableEurekaClient   //启动Eureka客户端
public class RunAppProviderUser {

	public static void main(String[] args) {
		SpringApplication.run(RunAppProviderUser.class, args);
	}
}
