package com.cg.admindata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 
 * @author Amburi Alekhya ResourceApplication for admin resource
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class AdminResourceApplication {
	/**
	 * 
	 * @param args String of arguments for main method
	 */
	public static void main(String[] args) {
		SpringApplication.run(AdminResourceApplication.class, args);
	}

}