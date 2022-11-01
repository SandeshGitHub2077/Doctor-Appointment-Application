package com.cg.adminconsumer.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * 
 * @author B.Rishita
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
	 * @return status of appointment is rturned
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
