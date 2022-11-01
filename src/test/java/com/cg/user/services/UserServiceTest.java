package com.cg.user.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.user.entities.User;
import com.cg.user.exceptions.UserAlreadyExistsException;
import com.cg.user.exceptions.UserNotFoundException;
import com.cg.user.repositories.UserJpaRepository;

@SpringBootTest(classes = {UserServiceTest.class})
class UserServiceTest {
	
	@Mock
	UserJpaRepository jpaRepository;
	
	@InjectMocks
	UserService userService;
	
	
	@Test
	void addUserTest() {
		User user = new User("abc","abc","ROLE_PATIENT");
		Optional<User> optionalUser = Optional.empty();
		when(jpaRepository.findById(user.getUserName())).thenReturn(optionalUser);
		when(jpaRepository.save(user)).thenReturn(user);
		assertEquals("New User inserted successfully",userService.addUser(user));
		verify(jpaRepository,times(1)).findById(user.getUserName());
		verify(jpaRepository,times(1)).save(user);
	}
	
	@Test
	void addUserFailTest() {
		User user = new User("abc","abc","ROLE_PATIENT");
		when(jpaRepository.findById(user.getUserName())).thenReturn(Optional.of(user));
		when(jpaRepository.save(user)).thenReturn(user);
		//assertNotEquals("New User inserted successfully",userService.addUser(user));
		assertThrows(UserAlreadyExistsException.class, ()->{userService.addUser(user);});
		verify(jpaRepository,times(1)).findById(user.getUserName());
		verify(jpaRepository,times(0)).save(user);
	}
	
	@Test
	void getUserByUserNameTest() {
		User user = new User("nith","abc","ROLE_ADMIN");
		when(jpaRepository.findById(user.getUserName())).thenReturn(Optional.of(user));
		assertEquals(user,userService.getUserByUserName(user.getUserName()));
		verify(jpaRepository,times(1)).findById(user.getUserName());
	}
	
	@Test
	void getUserByUserNameFailTest() {
		User user = new User("nith","abc","ROLE_ADMIN");
		when(jpaRepository.findById(user.getUserName())).thenReturn(Optional.empty());
		String userName = user.getUserName();
		assertThrows(UserNotFoundException.class, ()->userService.getUserByUserName(userName));
		verify(jpaRepository,times(1)).findById(user.getUserName());
	}
	
	@Test
	void deleteUserByUserNameTest() {
		User user = new User("nith","abc","ROLE_ADMIN");
		when(jpaRepository.findById(user.getUserName())).thenReturn(Optional.of(user));
		assertEquals("User successfully deleted",userService.deleteUserByUserName(user.getUserName()));
		verify(jpaRepository,times(1)).deleteById(user.getUserName());
	}
	@Test
	void deleteUserByUserNameFailTest() {
		User user = new User("nith","abc","ROLE_ADMIN");
		when(jpaRepository.findById(user.getUserName())).thenReturn(Optional.empty());
		String userName = user.getUserName();
		assertThrows(UserNotFoundException.class, ()->userService.deleteUserByUserName(userName));
		verify(jpaRepository,times(1)).findById(user.getUserName());
	}
	
	@Test
	void getAllUsersTest() {
		List<User> userList = new ArrayList<>();
		userList.add(new User("nith","abc","ROLE_ADMIN"));
		userList.add(new User("nithee","abcd","ROLE_ADMIN"));
		
		when(jpaRepository.findAll()).thenReturn(userList);
		
		assertEquals(userList, userService.getAllUsers());
		verify(jpaRepository,times(1)).findAll();
	}
}
