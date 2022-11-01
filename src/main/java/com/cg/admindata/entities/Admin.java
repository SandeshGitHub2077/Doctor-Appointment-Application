package com.cg.admindata.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 
 * @author Amburi Alekhya Getting all the entities of the admin class
 */
@Entity
@Table(name = "AdminTable")
public class Admin {
	/**
	 * User name of the admin
	 */
	@NotNull(message = "User name should not be Null")
	private String userName;
	/**
	 * User id of the admin
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull(message = "Admin Id should not be Null")
	private int adminId;
	/**
	 * User name of the admin
	 */
	@NotEmpty(message = "Admin Name is a mandatory Field")
	private String adminName;
	/**
	 * Mobile number of the admin
	 */
	@NotEmpty(message = "Mobile Number should not be empty")
	@Pattern(regexp = "^[6789]{1}[0-9]{9}$")
	private String mobileNumber;
	/**
	 * Email of the admin
	 */
	@NotEmpty(message = "Email should not be empty")
	@Email
	private String email;
	/**
	 * Password of the admin for login
	 */
	@Transient
	private String password;

	/**
	 * Default constructor of the admin class to initialize the Fields with default
	 * values
	 */
	public Admin() {
		super();
	}

	/**
	 * 
	 * @param userName     User name of the admin is stored in userName Field
	 * @param adminId      User id of the admin is stored in the userId Field
	 * @param adminName    User name of the admin is stored the adminName Field
	 * @param mobileNumber Mobile number of the admin is stored in the mobileNumber
	 *                     Field
	 * @param email        Email of the admin is stored in the email Field
	 * @param password     Password of the admin is stored in the password Field
	 */
	public Admin(String userName, int adminId, String adminName, String mobileNumber, String email, String password) {
		super();
		this.userName = userName;
		this.adminId = adminId;
		this.adminName = adminName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.password = password;
	}

	/**
	 * Getter method of userName field.
	 * 
	 * @return userName of the admin object
	 * 
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Setter method of the userName Field.
	 * 
	 * @param userName To set the userName of the admin object
	 * 
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Getter method of adminId field.
	 * 
	 * @return adminId of the admin object
	 * 
	 */
	public int getAdminId() {
		return adminId;
	}

	/**
	 * Setter method of the adminId Field.
	 * 
	 * @param adminId To set the adminId of the admin object
	 * 
	 */
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	/**
	 * Getter method of adminName field.
	 * 
	 * @return adminName of the admin object
	 * 
	 */
	public String getAdminName() {
		return adminName;
	}

	/**
	 * Setter method of the adminName Field.
	 * 
	 * @param adminName To set the adminName of the admin object
	 * 
	 */
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	/**
	 * Getter method of mobileNumber field.
	 * 
	 * @return mobileNumber of the admin object
	 * 
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * Setter method of the mobileNumber Field.
	 * 
	 * @param mobileNumber To set the mobileNumber of the admin object
	 * 
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * Getter method of email field.
	 * 
	 * @return email of the admin object
	 * 
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter method of the email Field.
	 * 
	 * @param email To set the email of the admin object
	 * 
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Getter method of password field.
	 * 
	 * @return password of the admin object
	 * 
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setter method of the password Field.
	 * 
	 * @param password To set the password of the admin object
	 * 
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Overridden toString() method
	 */
	@Override
	public String toString() {
		return "Admin [userName=" + userName + ", adminId=" + adminId + ", adminName=" + adminName + ", mobileNumber="
				+ mobileNumber + ", email=" + email + "]";
	}

}
