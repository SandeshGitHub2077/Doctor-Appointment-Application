package com.cg.patientconsumer.dtos;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Issarapu Gangadhar, Sandesh Mahajan Doctor class in patientConsumer
 *         project is a DTO which stores the data fields of other (Doctor
 *         module) modules
 *
 */
public class Doctor {
	private int doctorId;
	private String doctorName;
	private String doctorSpeciality;
	private String doctorLocation;
	private String hospitalName;
	private String mobileNumber;
	private String email;
	private String password;
	private String userName;
	private double chargedPerVisit;

	private List<AvailabilityDate> availabilityDates = new ArrayList<>();

	/**
	 * Default constructor
	 */
	public Doctor() {
		super();
	}

	/**
	 * 
	 * @param doctorId         Data member of the Doctor dto
	 * @param doctorName       Data member of the Doctor dto
	 * @param doctorSpeciality Data member of the Doctor dto
	 * @param userName         Data member of the Doctor dto
	 * @param chargedPerVisit  Data member of the Doctor dto
	 */
	public Doctor(int doctorId, String doctorName, String doctorSpeciality, String userName, double chargedPerVisit) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.doctorSpeciality = doctorSpeciality;
		this.userName = userName;
		this.chargedPerVisit = chargedPerVisit;
	}

	/**
	 * 
	 * @return getter for doctorId
	 */
	public int getDoctorId() {
		return doctorId;
	}

	/**
	 * 
	 * @param doctorId setter for doctorId
	 */
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	/**
	 * 
	 * @return getter for doctor Name
	 */
	public String getDoctorName() {
		return doctorName;
	}

	/**
	 * 
	 * @param doctorName setter for doctor Name
	 */
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	/**
	 * 
	 * @return getter for doctor Speciality
	 */
	public String getDoctorSpeciality() {
		return doctorSpeciality;
	}

	/**
	 * 
	 * @param doctorSpeciality setter for doctor Speciality
	 */
	public void setDoctorSpeciality(String doctorSpeciality) {
		this.doctorSpeciality = doctorSpeciality;
	}

	/**
	 * 
	 * @return getter for doctor Location
	 */
	public String getDoctorLocation() {
		return doctorLocation;
	}

	/**
	 * 
	 * @param doctorLocation setter for doctor Location
	 */
	public void setDoctorLocation(String doctorLocation) {
		this.doctorLocation = doctorLocation;
	}

	/**
	 * 
	 * @return getter for hospital Name
	 */
	public String getHospitalName() {
		return hospitalName;
	}

	/**
	 * 
	 * @param hospitalName setter for hospital Name
	 */
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
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
	 * @return getter for charged Per Visit
	 */
	public double getChargedPerVisit() {
		return chargedPerVisit;
	}

	/**
	 * 
	 * @param chargedPerVisit setter for charged Per Visit
	 */
	public void setChargedPerVisit(double chargedPerVisit) {
		this.chargedPerVisit = chargedPerVisit;
	}

	/**
	 * 
	 * @return getter for availability Dates
	 */
	public List<AvailabilityDate> getAvailabilityDates() {
		return availabilityDates;
	}

	/**
	 * 
	 * @param availabilityDates setter for availability Dates
	 */
	public void setAvailabilityDates(List<AvailabilityDate> availabilityDates) {
		this.availabilityDates = availabilityDates;
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
	 * @param userName setter for userName
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
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", doctorSpeciality=" + doctorSpeciality
				+ ", doctorLocation=" + doctorLocation + ", hospitalName=" + hospitalName + ", mobileNumber="
				+ mobileNumber + ", email=" + email + ", userName=" + userName + ", chargedPerVisit=" + chargedPerVisit
				+ ", availabilityDates=" + availabilityDates + "]";
	}

}