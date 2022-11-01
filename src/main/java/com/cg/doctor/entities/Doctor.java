package com.cg.doctor.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "doctor")
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "doctor_id")
	private int doctorId;

	@NotNull(message = "Doctor's name cannot be null")
	@Column(name = "doctorName")
	private String doctorName;

	@NotNull(message = "Doctor's speciality cannot be null")
	@Column(name = "doctorSpeciality")
	private String doctorSpeciality;

	@NotNull(message = "Doctor's location cannot be null")
	@Column(name = "doctorLocation")
	private String doctorLocation;

	@NotNull(message = "HospitalName cannot be null")
	@Column(name = "hospitalName")
	private String hospitalName;

	@NotNull(message = "MobileNumber cannot be null")
	@Column(name = "mobileNumber")
	@Pattern(regexp = "^[6789]{1}[0-9]{9}$")
	private String mobileNumber;

	@NotNull(message = "Doctor's email-id cannot be null")
	@Email(message = "Enter you'r email-id eg. john123@gmail.com")
	@Column(name = "email")
	private String email;

	@Transient
	private String password;

	@NotNull(message = "Doctor's User name cannot be null")
	@Column(name = "UserName")
	private String userName;

	@NotNull(message = "Charge per visit cannot be null")
	@Min(value = 1)
	@Column(name = "chargedPerVisit")
	private double chargedPerVisit;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "doctorId")
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

	public void setChargedPerVisit(@Min(value = 300) double chargedPerVisit) {
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
