package com.cg.patientconsumer.dtos;

import java.time.LocalDate;

/**
 * 
 * @author Issarapu Gangadhar, Sandesh Mahajan Appointment class in
 *         patientConsumer project is a DTO which stores the data fields of
 *         other (Appointment module) modules
 *
 */
public class Appointment {

	private int appointmentId;
	private int patientId;
	private int doctorId;
	private LocalDate appointmentDate;
	private String appointmentStatus;
	private String remark;

	/**
	 * 
	 * @param appointmentId     Data member of the appointment dto
	 * @param patientId         Data member of the appointment dto
	 * @param doctorId          Data member of the appointment dto
	 * @param appointmentDate   Data member of the appointment dto
	 * @param appointmentStatus Data member of the appointment dto
	 * @param remark            Data member of the appointment dto
	 */
	public Appointment(int appointmentId, int patientId, int doctorId, String appointmentDate, String appointmentStatus,
			String remark) {
		super();
		this.appointmentId = appointmentId;
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.appointmentDate = LocalDate.parse(appointmentDate);
		this.appointmentStatus = appointmentStatus;
		this.remark = remark;
	}

	/**
	 * Default constructor
	 */
	public Appointment() {
		super();
	}

	/**
	 * 
	 * @return getter for appointment id
	 */
	public int getAppointmentId() {
		return appointmentId;
	}

	/**
	 * 
	 * @param appointmentId setter for appointment id
	 */
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	/**
	 * 
	 * @return getter for patient id
	 */
	public int getPatientId() {
		return patientId;
	}

	/**
	 * 
	 * @param patientId setter for patient id
	 */
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	/**
	 * 
	 * @return getter for doctor id
	 */
	public int getDoctorId() {
		return doctorId;
	}

	/**
	 * 
	 * @param doctorId setter for doctor id
	 */
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	/**
	 * 
	 * @return getter for appointmentDate
	 */
	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	/**
	 * 
	 * @param appointmentDate setter for appointmentDate
	 */
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = LocalDate.parse(appointmentDate);
	}

	/**
	 * 
	 * @return getter for AppointmentStatus
	 */
	public String getAppointmentStatus() {
		return appointmentStatus;
	}

	/**
	 * 
	 * @param appointmentStatus setter for AppointmentStatus
	 */

	public void setAppointmentStatus(String appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}

	/**
	 * 
	 * @return getter for remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 
	 * @param remark setter for remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * Overridden toString method to return the custom object
	 */
	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", patientId=" + patientId + ", doctorId=" + doctorId
				+ ", appointmentDate=" + appointmentDate + ", appointmentStatus=" + appointmentStatus + ", remark="
				+ remark + "]";
	}
}
