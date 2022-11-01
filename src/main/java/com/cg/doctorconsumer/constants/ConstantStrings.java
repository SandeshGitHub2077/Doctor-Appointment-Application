package com.cg.doctorconsumer.constants;

public class ConstantStrings {
	
	/**
	 * This class is used for 
	 * declaring constants for 
	 * preventing the use of 
	 * same requests over and over again
	 */
	
	private ConstantStrings() {}
	
	
	public static final String ADD_DOCTOR = "http://book-my-doctor-doctor-service/doctors";
	public static final String UPDATE_DOCTOR = "http://book-my-doctor-doctor-service/doctors";
	public static final String GET_DOCTOR = "http://book-my-doctor-doctor-service/doctors/";
	public static final String DELETE_DOCTOR = "http://book-my-doctor-doctor-service/doctors/";
	public static final String GET_ALL_DOCTORS = "http://book-my-doctor-doctor-service/doctors";
	public static final String GET_DOCTORS_BY_SPECIALITY = "http://book-my-doctor-doctor-service/doctors/speciality/";
	public static final String GET_APPOINTMENTS_BY_DATE = "http://book-my-doctor-appointment-service/appointments/appointmentDate/";
	public static final String ADD_AVAILABILITY = "http://book-my-doctor-doctor-service/doctors/availabilityDates";
	public static final String UPDATE_AVAILABILITY = "http://book-my-doctor-doctor-service/doctors/availabilityDates";
	public static final String GET_APPOINTMENTS_FOR_DOCTOR = "http://book-my-doctor-appointment-service/appointments/doctorId/";
	public static final String GET_APPOINTMENT_STATUS = "http://book-my-doctor-appointment-service/appointments/";
	public static final String CHANGE_APPOINTMENT_STATUS = "http://book-my-doctor-appointment-service/appointments";
	public static final String GET_FEEDBACK_BY_ID = "http://book-my-doctor-feedback-service/feedbacks/";
	public static final String GET_FEEDBACKS_FOR_DOCTOR = "http://book-my-doctor-feedback-service/feedbacks/doctorId/";
	public static final String SET_APPOINTMENT_STATUS = "http://book-my-doctor-appointment-service/doctors/availabilityDates";
	public static final String GET_APPOINTMENT = "http://book-my-doctor-appointment-service/appointments/";
	public static final String GET_ALL_PATIENTS_FOR_DOCTOR = "http://book-my-doctor-patient-service/patient/";
}
