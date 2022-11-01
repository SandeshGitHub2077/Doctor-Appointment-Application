package com.cg.patient.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Patient {
	@Id
	//setter,getter,para cons
	@GeneratedValue
	@Min(value=0,message="PatientId is a mandatary field cannot be empty!!!")
	private int patientId;
	@NotEmpty(message="PatientName is a mandatory field cannot be empty!!!")
	private String patientName;
	@Pattern(regexp = "^[6789]{1}[0-9]{9}$",message = "You need to give a valid mobile number")
	@NotEmpty
	private String mobileNumber;
	@Email(message =" You need to give a valid email id" )
	@NotEmpty
	private String email;
	@NotEmpty(message="bloodGroup is a mandatory field cannot be empty!!!")
	private String bloodGroup;
	@NotEmpty(message="gender is a mandatory field cannot be empty!!!")
	private String gender;
	@Min(value=1,message="Patient age should not be lessthan 1!!!")
	@Max(value=100,message="Patient age should be lessthan 100!!!")
	private int age;
	@NotEmpty(message="address is a mandatory field cannot be empty!!!")
	private String address;
	@NotEmpty(message = "userName is a mandatory field cannot be empty!!!")
	private String userName;
	@Transient
	private String password;
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
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public String getMobileNumber() {
		return mobileNumber;
	}
	public Patient(
			@NotNull(message = "PatientId is a amandatory field,cannot be empty!!!") @Min(value = 1, message = "PatientId is a mandatary field,cannot be empty!!!") int patientId,
			@NotEmpty(message = "PatientName is a mandatory field,cannot be empty!!!") String patientName,
			@Pattern(regexp = "^[6789]{1}[0-9]{9}$", message = "You need to add a acorrect mobile number") String mobileNumber,
			@Email(message = " You need to give a correct email id") String email,
			@NotEmpty(message = "bloodGroup is a mandatory field,cannot be empty!!!") String bloodGroup,
			@NotEmpty(message = "gender is a mandatory field,cannot be empty!!!") String gender,
			@Min(value = 1, message = "Patient age should not be lessthan 1!!!") @Max(value = 150, message = "Patient age should be lessthan 150!!!") int age,
			@NotEmpty(message = "address is a mandatory field,cannot be empty!!!") String address, String userName,
			String password) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.bloodGroup = bloodGroup;
		this.gender = gender;
		this.age = age;
		this.address = address;
		this.userName = userName;
		this.password = password;
	}
	public Patient() {
		super();
	}
	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", mobileNumber=" + mobileNumber
				+ ", email=" + email + ", bloodGroup=" + bloodGroup + ", gender=" + gender + ", age=" + age
				+ ", address=" + address + ", userName=" + userName + ", password=" + password + "]";
	}
	
}