package com.cg.patientconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

/**
 * 
 * @author Issarapu Gangadhar, Sandesh Mahajan
 *
 */
@EnableEurekaClient
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Patient Consumer Resource", description = "Patient Consumer  Information"))
public class PatientConsumerResourceApplication {

	/**
	 * 
	 * @param args Arguments for main method
	 */
	public static void main(String[] args) {
		SpringApplication.run(PatientConsumerResourceApplication.class, args);
	}

	/**
	 * 
	 * @return RestTemplate
	 */
	@Bean
	@LoadBalanced
	public RestTemplate getBeanTemplate() {
		return new RestTemplate();
	}

}
