package com.cg.feedback.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author Sandesh Mahajan
 *
 */
@Entity
public class FeedBack {

	/**
	 * Base Feedback Module, contains data of the feedback class
	 */
	@Id
	@GeneratedValue
	@NotNull(message = "FeedBackId Mandatory field")
	@Min(value = 0, message = "Min value is 0")
	private int feedBackId;
	@NotNull(message = "Ratings mandatory field")
	@Min(value = 1, message = "Min value is 1")
	@Max(value = 10, message = "Max value is 10")
	private int rating;
	private String comment;
	@NotNull(message = "Doctor Id Mandatory field")
	@Min(value = 1, message = "Min value is 1")
	private int doctorId;
	@NotNull(message = "Patient Id: Mandatory field")
	@Min(value = 1, message = "Min value is 1")
	private int patientId;

	/**
	 * constructor for feedback class
	 */
	public FeedBack() {
	}

	/**
	 * 
	 * @param feedBackId Primary key in the feedback table
	 * @param rating     used to rate the doctor
	 * @param comment    Optional field to add comments
	 * @param doctorId   Id assigned to doctor
	 * @param patientId  Id assigned to patient
	 */
	public FeedBack(int feedBackId, int rating, String comment, int doctorId, int patientId) {
		super();
		this.feedBackId = feedBackId;
		this.rating = rating;
		this.comment = comment;
		this.doctorId = doctorId;
		this.patientId = patientId;
	}

	/**
	 * 
	 * @return getter for feedbackId
	 */
	public int getFeedBackId() {
		return feedBackId;
	}

	/**
	 * 
	 * @param feedBackId setter for feedBackId
	 */
	public void setFeedBackId(int feedBackId) {
		this.feedBackId = feedBackId;
	}

	/**
	 * 
	 * @return getter for rating
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * 
	 * @param rating setter for rating
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}

	/**
	 * 
	 * @return getter for comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * 
	 * @param comment setter for comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
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
	 * @return getter for patientId
	 */
	public int getPatientId() {
		return patientId;
	}

	/**
	 * 
	 * @param patientId setter for patient Id
	 */
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	/**
	 * Overridden toString method to return the custom object
	 */
	@Override
	public String toString() {
		return "FeedBack [feedBackId=" + feedBackId + ", rating=" + rating + ", comment=" + comment + ", doctorId="
				+ doctorId + ", patientId=" + patientId + "]";
	}

}
