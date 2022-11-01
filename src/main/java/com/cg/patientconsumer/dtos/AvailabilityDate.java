package com.cg.patientconsumer.dtos;

import java.time.LocalDate;

/**
 * 
 * @author Issarapu Gangadhar, Sandesh Mahajan AvailabilityDate class in
 *         patientConsumer project is a DTO which stores the data fields of
 *         other (AvailabilityDate module) modules
 *
 */
public class AvailabilityDate {
	private int availabilityId;
	private int doctorId;
	private LocalDate date;

	/**
	 * 
	 * @param availabilityId Data member of the AvailabilityDate dto
	 * @param doctorId       Data member of the AvailabilityDate dto
	 * @param date           Data member of the AvailabilityDate dto
	 */
	public AvailabilityDate(int availabilityId, int doctorId, String date) {
		super();
		this.availabilityId = availabilityId;
		this.doctorId = doctorId;
		this.date = LocalDate.parse(date);
	}

	/**
	 * 
	 * @return getter for availabilityId
	 */
	public int getAvailabilityId() {
		return availabilityId;
	}

	/**
	 * 
	 * @param availabilityId setter for availabilityId
	 */
	public void setAvailabilityId(int availabilityId) {
		this.availabilityId = availabilityId;
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
	 * @return getter for date
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * 
	 * @param date setter for date
	 */
	public void setDate(String date) {
		this.date = LocalDate.parse(date);
	}

	/**
	 * Default constructor
	 */
	public AvailabilityDate() {
		super();
	}

	/**
	 * Overridden toString method to return the custom object
	 */
	@Override
	public String toString() {
		return "AvailabilityDate [availabilityId=" + availabilityId + ", doctorId=" + doctorId + ", date=" + date + "]";
	}
}
