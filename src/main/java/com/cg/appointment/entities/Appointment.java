package com.cg.appointment.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author B.Rishita
 *
 */

@Entity
public class Appointment {

	/**
	 * Appointment ID Entity of type integer
	 */
	@Id
	@NotNull(message = "Appointment ID not found")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int appointmentId;

	/**
	 * Patient ID entity of type integer
	 */
	@NotNull(message = "Patient ID is a mandatory field cannot be null")
	@Min(value = 1, message = "Patient ID is a mandatory field cannot be null")
	private int patientId;

	/**
	 * Doctor Id entity of type integer
	 */
	@NotNull(message = "Doctor ID is a mandatory field cannot be null")
	@Min(value = 1, message = "Doctor ID is a mandatory field cannot be null")
	private int doctorId;

	/**
	 * appointment Date entity of type local date
	 */
	private LocalDate appointmentDate;

	/**
	 * Appointment Status entity of enum type AppointmentStatus
	 */
	// @NotEmpty(message = "Appointment Status cannot be empty")
	private AppointmentStatus appointmentStatus;

	/**
	 * remark entity of type string
	 */
	@NotEmpty(message = "Appointment Remark cannot be empty")
	private String remark;

	/**
	 * 
	 * @param appointmentId     appointment ID argument
	 * @param patientId         patient ID argument
	 * @param doctorId          doctor ID argument
	 * @param appointmentDate   appointment date ID argument
	 * @param appointmentStatus appointment status ID argument
	 * @param remark            remark ID argument
	 */
	public Appointment(int appointmentId, int patientId, int doctorId, LocalDate appointmentDate,
			AppointmentStatus appointmentStatus, String remark) {
		super();
		this.appointmentId = appointmentId;
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.appointmentDate = appointmentDate;
		this.appointmentStatus = appointmentStatus;
		this.remark = remark;
	}

	/**
	 * Default constructor for appointment Entity
	 */
	public Appointment() {
		super();
	}

	/**
	 * 
	 * @return get appointment Id
	 */
	public int getAppointmentId() {
		return appointmentId;
	}

	/**
	 * 
	 * @param appointmentId is set
	 */
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	/**
	 * 
	 * @return get patient Id
	 */
	public int getPatientId() {
		return patientId;
	}

	/**
	 * 
	 * @param patientId is set
	 */
	public void setPatient(int patientId) {
		this.patientId = patientId;
	}

	/**
	 * 
	 * @return get doctor Id
	 */
	public int getDoctorId() {
		return doctorId;
	}

	/**
	 * 
	 * @param doctorId is set
	 */
	public void setDoctor(int doctorId) {
		this.doctorId = doctorId;
	}

	/**
	 * 
	 * @return get appointment Date
	 */
	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	/**
	 * 
	 * @param appointmentDate is set
	 */
	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	/**
	 * 
	 * @return get appointment Status
	 */
	public AppointmentStatus getAppointmentStatus() {
		return appointmentStatus;
	}

	/**
	 * 
	 * @param appointmentStatus is set
	 */
	public void setAppointmentStatus(AppointmentStatus appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}

	/**
	 * 
	 * @return get remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 
	 * @param remark is set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", patientId=" + patientId + ", doctorId=" + doctorId
				+ ", appointmentDate=" + appointmentDate + ", appointmentStatus=" + appointmentStatus + ", remark="
				+ remark + "]";
	}

}
