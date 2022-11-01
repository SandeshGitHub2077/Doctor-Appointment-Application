package com.cg.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 
 * @author Kambala Nitheesh Kumar
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class UserResourceApplication {
	/**
	 * Main method for User resource module
	 * @param args for main method
	 */
	public static void main(String[] args) {
		SpringApplication.run(UserResourceApplication.class, args);
	}

}
