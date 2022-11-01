package com.cg.login.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.cg.login.entities.Principle;
import com.cg.login.entities.User;
import com.cg.login.repositories.UserJpaRepository;

@SpringBootTest(classes = { UserServiceTest.class })
class UserServiceTest {

	@Mock
	UserJpaRepository jpaRepository;

	@InjectMocks
	UserService userService;

	@Test
	void loadUserByUsernameTest() {
		User user = new User("abc", "abc", "ROLE_PATIENT");
		when(jpaRepository.findById(user.getUserName())).thenReturn(Optional.of(user));
		Principle principle = new Principle(user);
		assertEquals(principle.toString(), userService.loadUserByUsername(user.getUserName()).toString());
		verify(jpaRepository, times(1)).findById(user.getUserName());
	}
	@Test
	void loadUserByUsernameFailTest() {
		User user = new User("abc", "abc", "ROLE_PATIENT");
		when(jpaRepository.findById(user.getUserName())).thenReturn(Optional.empty());
		String name = user.getUserName();
		assertThrows(UsernameNotFoundException.class, ()->userService.loadUserByUsername(name));
		verify(jpaRepository, times(1)).findById(user.getUserName());
	}
}
