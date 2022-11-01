package com.cg.patientconsumer.dtos;

/**
 * 
 * @author Issarapu Gangadhar, Sandesh Mahajan Patient class in patientConsumer
 *         project is a DTO which stores the data fields of other (Patient
 *         module) modules
 *
 */
public class Patient {

	private int patientId;
	private String patientName;
	private String mobileNumber;
	private String email;
	private String bloodGroup;
	private String gender;
	private int age;
	private String address;
	private String userName;
	private String password;

	/**
	 * Default constructor
	 */
	public Patient() {
		super();
	}

	/**
	 * 
	 * @param patientId   Data member of the AvailabilityDate dto
	 * @param patientName Data member of the AvailabilityDate dto
	 * @param userName    Data member of the AvailabilityDate dto
	 */
	public Patient(int patientId, String patientName, String userName) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.userName = userName;
	}

	/**
	 * 
	 * @return getter for patient Id
	 */
	public int getPatientId() {
		return patientId;
	}

	/**
	 * 
	 * @param patientId setter for patient Id
	 */
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	/**
	 * 
	 * @return getter for patient Name
	 */
	public String getPatientName() {
		return patientName;
	}

	/**
	 * 
	 * @param patientName setter for patient Name
	 */
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	/**
	 * 
	 * @return getter for mobile Number
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * 
	 * @param mobileNumber setter for mobile Number
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * 
	 * @return getter for email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * @param email setter for email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 
	 * @return getter for bloodGroup
	 */
	public String getBloodGroup() {
		return bloodGroup;
	}

	/**
	 * 
	 * @param bloodGroup setter for bloodGroup
	 */
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	/**
	 * 
	 * @return getter for gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * 
	 * @param gender setter for gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * 
	 * @return getter for age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * 
	 * @param age setter for age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * 
	 * @return getter for address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 
	 * @param address setter for address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 
	 * @return getter for userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 
	 * @param userName setter for user Name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 
	 * @return getter for password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * @param password setter for password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Overridden toString method to return the custom object
	 */

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", mobileNumber=" + mobileNumber
				+ ", email=" + email + ", bloodGroup=" + bloodGroup + ", gender=" + gender + ", age=" + age
				+ ", address=" + address + ", userName=" + userName + ", password=" + password + "]";
	}

}
