package com.cg.doctorconsumer.dto;

import java.time.LocalDate;

public class Appointment {

	private int appointmentId;

	private int patientId;

	private int doctorId;

	private LocalDate appointmentDate;

	private String appointmentStatus;

	private String remark;

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

	public Appointment() {
		super();
	}

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatient(int patientId) {
		this.patientId = patientId;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctor(int doctorId) {
		this.doctorId = doctorId;
	}

	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = LocalDate.parse(appointmentDate);
	}

	public String getAppointmentStatus() {
		return appointmentStatus;
	}

	public void setAppointmentStatus(String appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}

	public String getRemark() {
		return remark;
	}

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
