package com.cg.patientconsumer.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * 
 * @author Issarapu Gangadhar, Sandesh Mahajan Appointment class in
 *         patientConsumer project is a DTO which stores the data fields of
 *         other (Appointment module) modules
 *
 */
public enum AppointmentStatus {

	/**
	 * Status is accepted
	 */
	ACCEPTED("Accepted"),

	/**
	 * status is In progress
	 */
	PROGRESS("Progress"),

	/**
	 * status is completed
	 */
	COMPLETED("Completed"),

	/**
	 * status is declined
	 */
	DECLINED("Declined"),

	/**
	 * status is cancelled
	 */
	CANCELLED("Cancelled");

	private String status;

	private AppointmentStatus(String status) {
		this.status = status;
	}

	/**
	 * 
	 * @return status
	 */
	public String getStatus() {
		return this.status;
	}

	/**
	 * 
	 * @param value Status value is used to get the status
	 * @return status of appointment is returned
	 */
	@JsonCreator
	public static AppointmentStatus getAppointmentStatusEnum(String value) {
		for (AppointmentStatus status : AppointmentStatus.values()) {
			if (status.getStatus().equals(value)) {
				return status;
			}
		}
		return null;

	}

}
