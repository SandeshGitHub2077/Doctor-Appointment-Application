package com.cg.login.webconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cg.login.services.UserService;
/**
 * 
 * @author Kambala Nitheesh Kumar
 *
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	/**
	 * UserService object to call business logic in service layer.
	 */
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;
	
	/**
	 * To configure the AuthenticationMangerBuilder and to provide password encoder.
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
	}
	

	/**
	 * To configure Authorization of the user.
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/admin*").hasRole("ADMIN").antMatchers("/patient*").hasRole("PATIENT")
				.antMatchers("/doctor*").hasRole("DOCTOR").and().formLogin();
	}
}
