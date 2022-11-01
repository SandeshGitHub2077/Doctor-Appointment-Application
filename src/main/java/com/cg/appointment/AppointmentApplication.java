package com.cg.appointment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

/**
 * 
 * @author B.Rishita
 *
 */
@SpringBootApplication
@EnableEurekaClient
@OpenAPIDefinition(info = @Info(title = "Appointment Resource", description = "Appointment Information"))
public class AppointmentApplication {

	/**
	 * 
	 * @param args Argument
	 */
	public static void main(String[] args) {
		SpringApplication.run(AppointmentApplication.class, args);
	}

}
