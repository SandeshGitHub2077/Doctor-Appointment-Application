package com.cg.register.dto;

public class User {
	/**
	 * Primary key for user table and User name for the user.
	 */

	private String userName;
	/**
	 * Password of the user.
	 */

	private String password;
	/**
	 * Role of the user.
	 */

	private String userRole;
	/**
	 * Specifies whether the User is active or not.
	 */
	private boolean isActive;

	/**
	 * Default constructor to initialize default values for the instance variables.
	 */
	public User() {
		super();
	}

	/**
	 * 
	 * @param userName User name of the user is stored in userName Field.
	 * @param password Password of the user is stored in userName Field.
	 * @param userRole User role of the user is stored in the userRole Field.
	 */
	public User(String userName, String password, String userRole) {
		super();
		this.userName = userName;
		this.password = password;
		this.userRole = userRole;
		this.isActive = false;
	}

	/**
	 * Getter method of userName field.
	 * 
	 * @return userName of the user object.
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Setter method of the userName Field.
	 * 
	 * @param userName To set the userName of the user object.
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Getter method of the password Field.
	 * 
	 * @return password of the user object.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setter method of the Password Field.
	 * 
	 * @param password To set the password field of the user object.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Getter method of the userRole Field.
	 * 
	 * @return User role of the User object.
	 */
	public String getUserRole() {
		return userRole;
	}

	/**
	 * Setter method for the userRole field.
	 * 
	 * @param userRole To set the userRole Field of the user object.
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	/**
	 * Getter method of the isActive field.
	 * 
	 * @return isActive returns the isActive field of the user object.
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * Setter method for the isActive field of the user object.
	 * 
	 * @param isActive To set isActive field of the user object.
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * Overridden toString() method.
	 */
	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", userRole=" + userRole + ", isActive="
				+ isActive + "]";
	}
}
