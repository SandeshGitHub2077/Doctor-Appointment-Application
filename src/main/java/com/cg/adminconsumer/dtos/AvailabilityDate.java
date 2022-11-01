package com.cg.adminconsumer.dtos;

import java.time.LocalDate;

public class AvailabilityDate {
	private int availabilityId;
	private int doctorId;
	private LocalDate date;

	public AvailabilityDate() {
		super();
		
	}

	public AvailabilityDate(int availabilityId, int doctorId, LocalDate date) {
		super();
		this.availabilityId = availabilityId;
		this.doctorId = doctorId;
		this.date = date;
	}

	public int getAvailabilityId() {
		return availabilityId;
	}

	public void setAvailabilityId(int availabilityId) {
		this.availabilityId = availabilityId;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctor(int doctorId) {
		this.doctorId = doctorId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "AvailabilityDates [availabilityId=" + availabilityId + ", doctor=" + doctorId + ", date=" + date + "]";
	}

}
