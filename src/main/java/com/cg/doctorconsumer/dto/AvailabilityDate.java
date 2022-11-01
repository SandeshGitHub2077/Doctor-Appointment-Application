package com.cg.doctorconsumer.dto;

import java.time.LocalDate;

public class AvailabilityDate {
	private int availabilityId;

	private int doctorId;

	private LocalDate date;

	public AvailabilityDate() {
		super();
	}

	public AvailabilityDate(int availabilityId, int doctorId, String date) {
		super();
		this.availabilityId = availabilityId;
		this.doctorId = doctorId;
		this.date = LocalDate.parse(date);
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

	public void setDate(String date) {
		this.date = LocalDate.parse(date);
	}

	@Override
	public String toString() {
		return "AvailabilityDates [availabilityId=" + availabilityId + ", doctor=" + doctorId + ", date=" + date + "]";
	}
}
