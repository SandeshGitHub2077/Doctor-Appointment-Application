package com.cg.patientconsumer.dtos;

/**
 * 
 * @author Issarapu Gangadhar, Sandesh Mahajan Feedback class in patientConsumer
 *         project is a DTO which stores the data fields of other (Feedback
 *         module) modules
 *
 */
public class Feedback {

	private int feedBackId;
	private int rating;
	private String comment;
	private int doctorId;
	private int patientId;

	/**
	 * Default constructor
	 */
	public Feedback() {
		super();
	}

	/**
	 * 
	 * @param feedBackId Data member of the Feedback dto
	 * @param rating     Data member of the Feedback dto
	 * @param comment    Data member of the Feedback dto
	 * @param doctorId   Data member of the Feedback dto
	 * @param patientId  Data member of the Feedback dto
	 */
	public Feedback(int feedBackId, int rating, String comment, int doctorId, int patientId) {
		super();
		this.feedBackId = feedBackId;
		this.rating = rating;
		this.comment = comment;
		this.doctorId = doctorId;
		this.patientId = patientId;
	}

	/**
	 * 
	 * @return getter for patientId
	 */
	public int getFeedBackId() {
		return feedBackId;
	}

	/**
	 * 
	 * @param feedBackId setter for feedBack Id
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
	 * @param patientId setter for patientId
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
