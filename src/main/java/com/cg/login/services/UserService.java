package com.cg.login.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cg.login.entities.Principle;
import com.cg.login.entities.User;
import com.cg.login.repositories.UserJpaRepository;
/**
 * 
 * @author Kambala Nitheesh Kumar
 *
 */
@Service
public class UserService implements UserDetailsService {
	/**
	 * Logger to to log the information of the UserService class.
	 */
 	Logger logger = LoggerFactory.getLogger(UserService.class);
 	/**
 	 * UserJpa Repository field to call spring-data-jpa command on the database.
 	 */
	@Autowired
	private UserJpaRepository jpaRepository;
	
	/**
	 * @param userName To load the user based on user name of the User.
	 * @return Return Principle object of the user.
	 */
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<User> optionalUser = jpaRepository.findById(userName);
		User user = null;
		if (optionalUser.isPresent()) {
			user = optionalUser.get();
			logger.info("Username is present in the user table");
			logger.info("New principle object is created");
			return new Principle(user);
		} else {
			String message = "User with the user name : " + userName + " is not found";
			logger.error(message);
			throw new UsernameNotFoundException(message);
		}
	}
}
