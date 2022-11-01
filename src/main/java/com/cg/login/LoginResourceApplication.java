package com.cg.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
/**
 * 
 * @author Kambala Nitheesh Kumar
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class LoginResourceApplication {
	/**
	 * 
	 * @param args for main method to run the login module resource
	 */
	public static void main(String[] args) {
		SpringApplication.run(LoginResourceApplication.class, args);
	}
	/**
	 * 
	 * @return BCryptPasswordEncoder object performed for encoding and decoding of the passwords.
	 */
	@Bean
	PasswordEncoder getPasswordEncoderBean() {
		return new BCryptPasswordEncoder();
	}
}
