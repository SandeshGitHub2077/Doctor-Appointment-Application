package com.cg.adminconsumer.dtos;

import java.util.ArrayList;
import java.util.List;

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

	public Doctor() {
		super();
	}

	public Doctor(int doctorId, String doctorName, String doctorSpeciality, String doctorLocation, String hospitalName,
			String mobileNumber, String email, String userName, double chargedPerVisit) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.doctorSpeciality = doctorSpeciality;
		this.doctorLocation = doctorLocation;
		this.hospitalName = hospitalName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.userName = userName;
		this.chargedPerVisit = chargedPerVisit;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDoctorSpeciality() {
		return doctorSpeciality;
	}

	public void setDoctorSpeciality(String doctorSpeciality) {
		this.doctorSpeciality = doctorSpeciality;
	}

	public String getDoctorLocation() {
		return doctorLocation;
	}

	public void setDoctorLocation(String doctorLocation) {
		this.doctorLocation = doctorLocation;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
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

	public double getChargedPerVisit() {
		return chargedPerVisit;
	}

	public void setChargedPerVisit(double chargedPerVisit) {
		this.chargedPerVisit = chargedPerVisit;
	}

	public List<AvailabilityDate> getAvailabilityDates() {
		return availabilityDates;
	}

	public void setAvailabilityDates(List<AvailabilityDate> availabilityDates) {
		this.availabilityDates = availabilityDates;
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
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", doctorSpeciality=" + doctorSpeciality
				+ ", doctorLocation=" + doctorLocation + ", hospitalName=" + hospitalName + ", mobileNumber="
				+ mobileNumber + ", email=" + email + ", userName=" + userName + ", chargedPerVisit=" + chargedPerVisit
				+ ", availabilityDates=" + availabilityDates + "]";
	}
}
