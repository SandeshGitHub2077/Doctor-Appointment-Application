package com.cg.feedback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 
 * @author Sandesh Mahajan This class is used for running the spring application
 *
 */
@EnableEurekaClient
@SpringBootApplication
public class FeedBackResourceApplication {
	/**
	 * 
	 * @param args	arguments for main method
	 */
	public static void main(String[] args) {
		SpringApplication.run(FeedBackResourceApplication.class, args);
	}

}
