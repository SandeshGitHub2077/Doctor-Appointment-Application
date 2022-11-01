package com.cg.adminconsumer.dtos;

public class Admin {
	private String userName;
	private int adminId;
	private String adminName;
	private String mobileNumber;
	private String email;
	private String password;

	public Admin() {
		super();
	}

	public Admin(String userName, int adminId, String adminName, String mobileNumber, String email, String password) {
		super();
		this.userName = userName;
		this.adminId = adminId;
		this.adminName = adminName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [userName=" + userName + ", adminId=" + adminId + ", adminName=" + adminName + ", mobileNumber="
				+ mobileNumber + ", email=" + email + "]";
	}

}
