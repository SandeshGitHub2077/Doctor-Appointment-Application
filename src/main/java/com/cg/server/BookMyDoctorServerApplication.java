package com.cg.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BookMyDoctorServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookMyDoctorServerApplication.class, args);
	}

}
