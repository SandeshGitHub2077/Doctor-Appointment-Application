package com.cg.login.entities;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
/**
 * 
 * @author Kambala Nitheesh Kumar
 *
 */
public class Principle implements UserDetails, Serializable {
	/**
	 * Serial version Uid for Principle class
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * User object to access the object for login
	 */
	private User user;
	/**
	 * Default constructor for Principle class
	 */
	public Principle() {
		super();
	}
	/**
	 * 
	 * @param user User class object which store the user object in class Field
	 */
	public Principle(User user) {
		super();
		this.user = user;
	}
	
	/**
	 * For getting the authorities of the user trying to login
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.stream(user.getUserRole().split(",")).map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}
	
	/**
	 * Used to get the password of the user trying to login.
	 */
	@Override
	public String getPassword() {
		return user.getPassword();
	}
	/**
	 * Used to get the User Name of the user trying to login.
	 */
	@Override
	public String getUsername() {
		return user.getUserName();
	}
	/**
	 * Used to check is the User account is expired or not.
	 */
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	/**
	 * Used to check is the User account is locked or not.
	 */
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	/**
	 * Used to check is the User account credentials are expired or not.
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	/**
	 * Used to check if the account is enabled or not.
	 */
	@Override
	public boolean isEnabled() {
		return true;
	}
	/**
	 * toString() overridden.
	 */
	@Override
	public String toString() {
		return "Principle [user=" + user + "]";
	}
	
}
