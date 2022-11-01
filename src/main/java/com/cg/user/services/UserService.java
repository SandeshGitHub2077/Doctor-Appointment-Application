package com.cg.user.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.user.entities.User;
import com.cg.user.exceptions.UserAlreadyExistsException;
import com.cg.user.exceptions.UserNotFoundException;
import com.cg.user.repositories.UserJpaRepository;

/**
 * 
 * @author Kambala Nitheesh Kumar
 *
 */
@Service
public class UserService {
	/**
	 * Logger to log the information
	 */
	Logger logger = LoggerFactory.getLogger(UserService.class);

	/**
	 * UserJpaRepository type object to call Database operations
	 */
	@Autowired
	private UserJpaRepository jpaRepository;

	/**
	 * Adds User into the database if user is not present in the database else an
	 * exception is thrown
	 * 
	 * @param user User data type object
	 * @return String containing information about the operation
	 */
	public String addUser(User user) {
		logger.info("inside add user service method");
		String result = "New User inserted successfully";
		if (!(jpaRepository.findById(user.getUserName())).isPresent()) {
			logger.info("inside add user service method ----> data base doesn't contain the user");
			jpaRepository.save(user);
			logger.info("inside add user service method ----> user is added into the data base");
		} else {
			logger.error("inside add user service method ----> data base already contains the user");
			throw new UserAlreadyExistsException("data base already contains the user : " + user.getUserName());
		}
		return result;
	}
	
	/**
	 * Returns 
	 * @param userName User name of the User object
	 * @return User Object based on user name
	 */
	public User getUserByUserName(String userName) {
		logger.info("inside get user by user name service method");
		Optional<User> retrievedUser = jpaRepository.findById(userName);
		if (retrievedUser.isPresent()) {
			logger.info("inside get user by username service method ----> data base contains the user");
			logger.info("inside get user by username service method ----> returning the user object");
			return retrievedUser.get();
		}
		logger.error("inside get user by username service method ----> data base doesn't contain the user");
		throw new UserNotFoundException("data base doesn't contain the user: " + userName);
	}

	public String deleteUserByUserName(String userName) {
		logger.info("inside delete user by user name service method");
		String result = "User successfully deleted";
		if (jpaRepository.findById(userName).isPresent()) {
			jpaRepository.deleteById(userName);
			logger.info("inside delete user by user name service method ----> user has been successfully deleted");
		} else {
			logger.error("inside delete user by username service method ----> data base doesn't contain the user");
			throw new UserNotFoundException("data base doesn't contain the user: " + userName);
		}
		return result;
	}

	public List<User> getAllUsers() {
		logger.info("inside get all users service method");
		logger.info("inside get all users service method -----> returning all the users from the data base");
		return jpaRepository.findAll();
	}

}
