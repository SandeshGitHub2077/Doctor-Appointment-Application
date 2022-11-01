package com.cg.doctorconsumer.dto;

public class FeedBack {

	private int feedBackId;

	private int rating;

	private String comment;

	private int doctorId;

	private int patientId;

	public FeedBack() {

	}

	public FeedBack(int feedBackId, int rating, String comment, int doctorId, int patientId) {
		super();
		this.feedBackId = feedBackId;
		this.rating = rating;
		this.comment = comment;
		this.doctorId = doctorId;
		this.patientId = patientId;
	}

	public int getFeedBackId() {
		return feedBackId;
	}

	public void setFeedBackId(int feedBackId) {
		this.feedBackId = feedBackId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	@Override
	public String toString() {
		return "FeedBack [feedBack_id=" + feedBackId + ", rating=" + rating + ", comment=" + comment + ", doctorId="
				+ doctorId + ", patientId=" + patientId + "]";
	}
}
