package com.cg.adminconsumer.dtos;

public class Patient {

	private int patientId;
	private String patientName;
	private long mobileNumber;
	private String email;
	private String bloodGroup;
	private String gender;
	private int age;
	private String address;
	private String userName;
	private String password;

	public Patient() {
		super();
	}

	public Patient(int patientId, String patientName, long mobileNumber, String email, String bloodGroup, String gender,
			int age, String address, String userName, String password) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.bloodGroup = bloodGroup;
		this.gender = gender;
		this.age = age;
		this.address = address;
		this.userName=userName;
		this.password=password;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", mobileNumber=" + mobileNumber
				+ ", email=" + email + ", bloodGroup=" + bloodGroup + ", gender=" + gender + ", age=" + age
				+ ", address=" + address + ", userName=" + userName + "]";
	}

}
