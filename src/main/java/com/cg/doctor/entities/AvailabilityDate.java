package com.cg.doctor.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

@Entity
public class AvailabilityDate {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "availability_id")
	private int availabilityId;

	@NotNull(message = "Doctor cannot be null for an accurate availablity id")
	@Min(value = 1)
	@Column(name = "doctorId")
	private int doctorId;

	@NonNull
	@Column(name = "availability_date")
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
