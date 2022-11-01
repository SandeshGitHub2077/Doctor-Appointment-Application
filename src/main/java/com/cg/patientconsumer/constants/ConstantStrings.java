package com.cg.patientconsumer.constants;

/**
 * 
 * @author Issarapu Gangadhar, Sandesh Mahajan ConstantStrings is used to store
 *         the server-client names of other Microservices
 *
 */
public class ConstantStrings {
	/**
	 * GETPATIENTBYID gets patient id from patient module
	 */
	public static final String GETPATIENTBYID = "http://book-my-doctor-patient-service/patients/";
	/**
	 * GETALLPATIENTS gets all patient id list from patient module
	 */
	public static final String GETALLPATIENTS = "http://book-my-doctor-patient-service/patients";
	/**
	 * ADDPATIENT adds patient in patient database through patient module
	 */
	public static final String ADDPATIENT = "http://book-my-doctor-patient-service/patients";
	/**
	 * UPDATEPATIENT updates a patient in the patient database through patient
	 * module
	 */
	public static final String UPDATEPATIENT = "http://book-my-doctor-patient-service/patients";
	/**
	 * REMOVEPATIENTBYID remove a patient object from patient database
	 */
	public static final String REMOVEPATIENTBYID = "http://book-my-doctor-patient-service/patients/";
	/**
	 * ADDFEEDBACK adds feedback in feedback database through feedback module
	 */
	public static final String ADDFEEDBACK = "http://book-my-doctor-feedback-service/feedbacks";
	/**
	 * GETDOCTORBYID gets doctor object using doctor id from doctor database
	 */
	public static final String GETDOCTORBYID = "http://book-my-doctor-doctor-service/doctors/";
	/**
	 * GETAPPOINTMENTBYID gets appointment ovjects using appointment id from
	 * appointment database
	 */
	public static final String GETAPPOINTMENTBYID = "http://book-my-doctor-appointment-service/appointments/";
	/**
	 * BOOKAPPOINTMENT books an appointment
	 */
	public static final String BOOKAPPOINTMENT = "http://book-my-doctor-appointment-service/appointments";
	/**
	 * ADDAVAILABILITYDATE adds availability date in availability database through
	 * doctor module
	 */
	public static final String ADDAVAILABILITYDATE = "http://book-my-doctor-doctor-service/doctors/availabilityDates";
	/**
	 * GETAPPOINTMENTBYDOCTORID gets availability object using doctor id from
	 * availability database
	 */
	public static final String GETAPPOINTMENTBYDOCTORID = "http://book-my-doctor-doctor-service/doctors/availabilityDates/";
	
	public static final String GETALLAVAILABLEDATESFORDOCTOR = "http://book-my-doctor-doctor-service/doctors/availabilityDates/";
	/**
	 * Default constructor
	 */
	private ConstantStrings() {
		super();
	}
}