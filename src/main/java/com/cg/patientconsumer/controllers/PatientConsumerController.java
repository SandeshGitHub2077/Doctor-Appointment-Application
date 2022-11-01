package com.cg.patientconsumer.controllers;

import static com.cg.patientconsumer.constants.ConstantStrings.ADDAVAILABILITYDATE;
import static com.cg.patientconsumer.constants.ConstantStrings.ADDFEEDBACK;
import static com.cg.patientconsumer.constants.ConstantStrings.ADDPATIENT;
import static com.cg.patientconsumer.constants.ConstantStrings.BOOKAPPOINTMENT;
import static com.cg.patientconsumer.constants.ConstantStrings.GETALLAVAILABLEDATESFORDOCTOR;
import static com.cg.patientconsumer.constants.ConstantStrings.GETALLPATIENTS;
import static com.cg.patientconsumer.constants.ConstantStrings.GETAPPOINTMENTBYDOCTORID;
import static com.cg.patientconsumer.constants.ConstantStrings.GETAPPOINTMENTBYID;
import static com.cg.patientconsumer.constants.ConstantStrings.GETDOCTORBYID;
import static com.cg.patientconsumer.constants.ConstantStrings.GETPATIENTBYID;
import static com.cg.patientconsumer.constants.ConstantStrings.REMOVEPATIENTBYID;
import static com.cg.patientconsumer.constants.ConstantStrings.UPDATEPATIENT;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.patientconsumer.dtos.Appointment;
import com.cg.patientconsumer.dtos.AvailabilityDate;
import com.cg.patientconsumer.dtos.Doctor;
import com.cg.patientconsumer.dtos.Feedback;
import com.cg.patientconsumer.dtos.Patient;
import com.cg.patientconsumer.exceptions.DoctorNotAvailableException;
import com.cg.patientconsumer.exceptions.IdNotFoundException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

/**
 * 
 * @author Issarapu Gangadhar , Sandesh Mahajan Controller class for Patient
 *         consumer. Can perform add patient, update patient, remove patient,
 *         get-patient-by-id, get-all-patient-list,
 *         get-doctor-availability-dates, Book-an-appointment,
 *         get-appointment-status, cancel-appointment, add-feedback
 *
 */
@RestController
@RequestMapping("/patientconsumer")
public class PatientConsumerController {
	/**
	 * Logger file to log the information
	 */
	Logger logger = org.slf4j.LoggerFactory.getLogger(PatientConsumerController.class);

	/**
	 * Patient-consumer service field is used to perform business logic for adding,
	 * updating, removing patient, get-patient-by-id, get-all-patient-list, *
	 * get-doctor-availability-dates, Book-an-appointment, get-appointment-status,
	 * cancel-appointment and add-feedback
	 */
	@Autowired
	RestTemplate restTemplate;

	/**
	 * 
	 * @param patientId used for searching patient entry in database
	 * @return patient object, contains all the fields related to patient
	 * @throws IdNotFoundException Exception thrown when Id is not present in
	 *                             database
	 */
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Fetching patient", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseInfo.class)) }), })
	@Operation(summary = "Getting Patient by id")
	@GetMapping("/patients/{id}")
	public Patient getPatientById(@PathVariable("id") int patientId) {
		logger.info("Fetching patient in DataBase.");
		return restTemplate.getForObject(GETPATIENTBYID + patientId, Patient.class);
	}

	/**
	 * 
	 * @return List of Patient objects present in database
	 */
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Getting patients", content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ResponseInfo.class))) }), })
	@Operation(summary = "Get List Of Patients")
	@GetMapping("/patients")
	public List<Patient> getAllPatients() {
		logger.info("Fetching all patients in DataBase.");
		return Arrays.asList(restTemplate.getForObject(GETALLPATIENTS, Patient[].class));
	}

	/**
	 * 
	 * @param patient Patient object, contains the patient data to be added
	 * @param request HttpServletRequest type object to get the information about
	 *                the request headers
	 * @return ResponseInfo object as an ResponseEntity, contains HttpStatus
	 *         Information
	 */
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Adding Patient By Id", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseInfo.class)) }),
			@ApiResponse(responseCode = "409", description = "patient already exists", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorInfo.class)) }) })
	@Operation(summary = "Add Patient")
	@PostMapping("/patients")
	public ResponseEntity<ResponseInfo> addPatient(@RequestBody Patient patient, HttpServletRequest request) {
		logger.info("Adding patient in DataBase.");
		return restTemplate.postForEntity(ADDPATIENT, patient, ResponseInfo.class);
	}

	/**
	 * 
	 * @param patient Patient object, contains details about a patient
	 * @param request HttpServletRequest type object to get the information about
	 *                the request headers
	 * @return ResponseInfo object as an ResponseEntity, contains HttpStatus
	 *         Information
	 */
	@ApiResponses(value = {
			@ApiResponse(responseCode = "202", description = "Updating Patient", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseInfo.class)) }),
			@ApiResponse(responseCode = "404", description = "patient not found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorInfo.class)) }) })
	@Operation(summary = "Updating patient")

	@PutMapping("/patients")
	public ResponseEntity<ResponseInfo> updatePatient(@RequestBody Patient patient, HttpServletRequest request) {
		logger.info("Updating patient in DataBase.");
		restTemplate.put(UPDATEPATIENT, patient, ResponseInfo.class);
		String msg = "Patient updated Successfully";
		ResponseInfo info = new ResponseInfo(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED.name(), msg,
				request.getRequestURI());
		logger.info("Patient updated in DataBase.");
		return new ResponseEntity<>(info, HttpStatus.ACCEPTED);
	}

	/**
	 * 
	 * @param patientId used for searching patient entry in database
	 * @param request   HttpServletRequest type object to get the information about
	 *                  the request headers
	 * @return ResponseInfo object as an ResponseEntity, contains HttpStatus
	 *         Information
	 * @throws IdNotFoundException, Exception thrown when Id is not present in
	 *                              database
	 */
	@ApiResponses(value = {
			@ApiResponse(responseCode = "202", description = "Removing patients", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseInfo.class)) }),
			@ApiResponse(responseCode = "404", description = "patient not found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorInfo.class)) }) })
	@Operation(summary = "Remove Patient By Id")

	@DeleteMapping("/patients/{id}")
	public ResponseEntity<ResponseInfo> removePatientById(@PathVariable("id") int patientId,
			HttpServletRequest request) {
		logger.info("Removing Patient in DataBase.");
		restTemplate.delete(REMOVEPATIENTBYID + patientId, Patient.class);
		String msg = "Patient removed Successfully";
		ResponseInfo info = new ResponseInfo(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED.name(), msg,
				request.getRequestURI());
		logger.info("Patient removed from DataBase.");
		return new ResponseEntity<>(info, HttpStatus.ACCEPTED);
	}

	/**
	 * 
	 * @param feedBack Feedback object, contains details about feedback
	 * @param request  HttpServletRequest type object to get the information about
	 *                 the request headers
	 * @return ResponseInfo object as an ResponseEntity, contains HttpStatus
	 *         Information
	 */
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Adding Feedback", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseInfo.class)) }),
			@ApiResponse(responseCode = "409", description = "Feedback already exists", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorInfo.class)) }) })
	@Operation(summary = "Add Feedback")

	@PostMapping("/feedbacks")
	public ResponseEntity<ResponseInfo> addFeedBack(@RequestBody Feedback feedBack, HttpServletRequest request) {
		logger.info("Adding Feedback in DataBase.");
		int doctorId = feedBack.getDoctorId();
		int patientId = feedBack.getPatientId();
		restTemplate.getForObject(GETDOCTORBYID + doctorId, Doctor.class);
		restTemplate.getForObject(GETPATIENTBYID + patientId, Patient.class);
		return restTemplate.postForEntity(ADDFEEDBACK, feedBack, ResponseInfo.class);
	}

	/**
	 * 
	 * @param appointment Appointment object, contains details about appointment
	 * @param request     HttpServletRequest type object to get the information
	 *                    about the request headers
	 * @return ResponseInfo object as an ResponseEntity, contains HttpStatus
	 *         Information
	 */
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Booking Appointment", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseInfo.class)) }),
			@ApiResponse(responseCode = "409", description = "Booking already exists", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorInfo.class)) }) })
	@Operation(summary = "Book Appointment")
	@PostMapping("/appointments")
	public ResponseEntity<ResponseInfo> bookAppointment(@RequestBody Appointment appointment,
			HttpServletRequest request) {
		logger.info("Booking apppointment.");
		appointment.setAppointmentStatus("Progress");
		int pid = appointment.getPatientId();
		int did = appointment.getDoctorId();
		restTemplate.getForObject(GETPATIENTBYID + pid, Patient.class);
		Doctor doctor = restTemplate.getForObject(GETDOCTORBYID + did, Doctor.class);
		boolean isPresent = false;
		AvailabilityDate doctorAvailableDate = null;
		if (doctor != null) {
			for (AvailabilityDate availabilityDate : doctor.getAvailabilityDates()) {
				LocalDate date = availabilityDate.getDate();
				if (date.equals(appointment.getAppointmentDate())) {
					doctorAvailableDate = availabilityDate;
					isPresent = true;
					break;
				}
			}
			if (isPresent) {
				logger.info("Appointment booked.");
				restTemplate.delete("http://book-my-doctor-doctor-service/doctors/availabilityDates/"
						+ doctorAvailableDate.getAvailabilityId());
				return restTemplate.postForEntity(BOOKAPPOINTMENT, appointment, ResponseInfo.class);
			}
		}

		throw new DoctorNotAvailableException(
				"Doctor is not available on the date : " + appointment.getAppointmentDate());

	}

	/**
	 * 
	 * @param appointmentId      Used for searching the appointment entry in
	 *                           database
	 * @param httpServletRequest HttpServletRequest type object to get the
	 *                           information about the request headers
	 * @return ResponseInfo object as an ResponseEntity, contains HttpStatus
	 *         Information
	 */
	@ApiResponses(value = {
			@ApiResponse(responseCode = "202", description = "Cancelling Appointment", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseInfo.class)) }),
			@ApiResponse(responseCode = "404", description = "Appointment not found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorInfo.class)) }) })
	@Operation(summary = "Cancel Appointment By Appointment Id")
	@PatchMapping("/appointments/{id}")
	public ResponseEntity<ResponseInfo> cancelAppointment(@PathVariable("id") int appointmentId,
			HttpServletRequest httpServletRequest) {
		logger.info("Cancelling appointment.");
		Appointment appointment = restTemplate.getForObject(GETAPPOINTMENTBYID + appointmentId, Appointment.class);
		int id = 0;
		LocalDate date = LocalDate.now();
		if (appointment != null) {
			appointment.setAppointmentStatus("Cancelled");
			restTemplate.put(BOOKAPPOINTMENT, appointment);
			id = appointment.getDoctorId();
			date = appointment.getAppointmentDate();
		}
		AvailabilityDate availabilityDate = new AvailabilityDate();
		availabilityDate.setDoctorId(id);
		availabilityDate.setDate(date.toString());
		String message = "Appointment Calcelled";
		List<AvailabilityDate> dates = Arrays
				.asList(restTemplate.getForObject(GETALLAVAILABLEDATESFORDOCTOR + id, AvailabilityDate[].class));
		for (AvailabilityDate avDate : dates) {
			if (avDate.getDate().equals(date)) {
				ResponseInfo info = new ResponseInfo(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED.name(), message,
						httpServletRequest.getRequestURI());
				return new ResponseEntity<>(info, HttpStatus.ACCEPTED);
			}
		}
		logger.info("Appointment cancelled.");
		restTemplate.postForEntity(ADDAVAILABILITYDATE, availabilityDate, ResponseInfo.class);

		ResponseInfo info = new ResponseInfo(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED.name(), message,
				httpServletRequest.getRequestURI());
		return new ResponseEntity<>(info, HttpStatus.ACCEPTED);
	}

	/**
	 * 
	 * @param appointmentId      used for searching appointment entry in database
	 * @param httpServletRequest HttpServletRequest type object to get the
	 *                           information about the request headers
	 * @return ResponseInfo object as an ResponseEntity, contains HttpStatus
	 *         Information
	 */
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Getting Appointment status", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseInfo.class)) }),
			@ApiResponse(responseCode = "404", description = "Appointment not found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorInfo.class)) }) })
	@Operation(summary = "Fetch appointment status by Appointment Id")

	@GetMapping("/appointments/{id}")
	public ResponseEntity<ResponseInfo> getAppointmentStatus(@PathVariable("id") int appointmentId,
			HttpServletRequest httpServletRequest) {
		Appointment appointment = restTemplate.getForObject(GETAPPOINTMENTBYID + appointmentId, Appointment.class);
		String message = "";
		if (appointment != null) {
			message = appointment.getAppointmentStatus();
		}
		ResponseInfo rinfo = new ResponseInfo(HttpStatus.OK.value(), HttpStatus.OK.name(), message,
				httpServletRequest.getRequestURI());
		logger.info("Getting appointment status.");
		return new ResponseEntity<>(rinfo, HttpStatus.OK);
	}

	/**
	 * 
	 * @param doctorId           used for searching doctor entry in database
	 * @param httpServletRequest HttpServletRequest type object to get the
	 *                           information about the request headers
	 * @return List of Availability date objects present in database
	 */
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Fetching doctor availablitiy dates", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ResponseInfo.class))) }), })
	@Operation(summary = "Fetch doctor availablity dates by Doctor Id")

	@GetMapping("/doctors/availability/{did}")
	public List<AvailabilityDate> getDoctorAvailability(@PathVariable("did") int doctorId,
			HttpServletRequest httpServletRequest) {
		logger.info("Fetching Doctor availability dates.");
		return Arrays.asList(restTemplate.getForObject(GETAPPOINTMENTBYDOCTORID + doctorId, AvailabilityDate[].class));
	}
}
