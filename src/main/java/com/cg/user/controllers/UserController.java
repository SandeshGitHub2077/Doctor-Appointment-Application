package com.cg.user.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.user.entities.User;
import com.cg.user.services.UserService;

/**
 * 
 * @author Kambala Nitheesh Kumar
 * 
 */
@RestController
@RequestMapping("/users")
public class UserController {
	/**
	 * Logger file to log the information
	 */
	Logger logger = LoggerFactory.getLogger(UserController.class);

	/**
	 * User Service field is used to perform business logic for adding user,
	 * updating user, deleting user, getting user
	 */
	@Autowired
	private UserService userService;

	/**
	 * 
	 * @param user               User object that will be added.
	 * @param httpServletRequest HttpServletRequest Type object to get the
	 *                           information about the request headers
	 * @return ResponseInfo object as an ResponseEntity, contains HttpStatus
	 *         Information.
	 * 
	 */
	@PostMapping()
	public ResponseEntity<ResponseInfo> adduser(@Valid @RequestBody User user, HttpServletRequest httpServletRequest) {
		logger.info("Inside add user controller method");
		String message = userService.addUser(user);
		ResponseInfo responseInfo = new ResponseInfo(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED.name(), message,
				httpServletRequest.getRequestURI());
		return new ResponseEntity<>(responseInfo, HttpStatus.ACCEPTED);
	}

	/**
	 * 
	 * @param userName,          The name of the user to find the user object from
	 *                           the database
	 * @param httpServletRequest HttpServletRequest Type object to get the
	 *                           information about the request headers
	 * @return Return the user object that was found by using user name
	 */
	@GetMapping("/{name}")
	public User getUserByUserName(@PathVariable(name = "name") String userName, HttpServletRequest httpServletRequest) {
		logger.info("Inside get user by user name controller method");
		return userService.getUserByUserName(userName);
	}

	/**
	 * 
	 * @param httpServletRequest HttpServletRequest Type object to get the
	 *                           information about the request headers
	 * @return Returns all the user objects present in the database
	 */
	@GetMapping("")
	public List<User> getAllUsers(HttpServletRequest httpServletRequest) {
		logger.info("Inside get all users controller method");
		return userService.getAllUsers();
	}

	/**
	 * 
	 * @param username           The name of the user to find the object and delete
	 *                           it from the database.
	 * @param httpServletRequest HttpServletRequest Type object to get the
	 *                           information about the request headers
	 * @return ResponseInfo object as an ResponseEntity, contains HttpStatus
	 *         Information.
	 */
	@DeleteMapping("/{name}")
	public ResponseEntity<ResponseInfo> deleteUserByUserName(@PathVariable(name = "name") String username,
			HttpServletRequest httpServletRequest) {
		logger.info("Inside delete user by user name controller method");
		String message = userService.deleteUserByUserName(username);
		ResponseInfo responseInfo = new ResponseInfo(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED.name(), message,
				httpServletRequest.getRequestURI());
		return new ResponseEntity<>(responseInfo, HttpStatus.ACCEPTED);
	}
}
