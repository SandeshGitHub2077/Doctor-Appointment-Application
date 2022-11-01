package com.cg.adminconsumer.controllers;

import java.time.LocalDate;
import java.util.Arrays;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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


import com.cg.adminconsumer.dtos.Admin;
import com.cg.adminconsumer.dtos.Appointment;
import com.cg.adminconsumer.dtos.AppointmentStatus;
import com.cg.adminconsumer.dtos.AvailabilityDate;
import com.cg.adminconsumer.dtos.Doctor;
import com.cg.adminconsumer.dtos.Patient;
import static com.cg.adminconsumer.constants.ConstantStrings.ADDADMIN;
import static com.cg.adminconsumer.constants.ConstantStrings.ADDDOCTOR;
import static com.cg.adminconsumer.constants.ConstantStrings.ADDPATIENT;
import static com.cg.adminconsumer.constants.ConstantStrings.ADDAPPOINTMENT;
import static com.cg.adminconsumer.constants.ConstantStrings.ADMINBYID;
import static com.cg.adminconsumer.constants.ConstantStrings.DOCTORBYID;
import static com.cg.adminconsumer.constants.ConstantStrings.PATIENTBYID;
import static com.cg.adminconsumer.constants.ConstantStrings.*;
import static com.cg.adminconsumer.constants.ConstantStrings.GETAPPOINTMENT;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/adminconsumer")
public class AdminConsumerController {
	@Autowired
	RestTemplate restTemplate;

	Logger logger = LoggerFactory.getLogger(AdminConsumerController.class);

	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Fetching all admins", content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ResponseInfo.class))) }) })
	@Operation(summary = "Fetching all the admins from the database")
	@GetMapping("/admins")
	List<Admin> getAllAdmins(HttpServletRequest request) {
		logger.info("Getting All admins from admin database using admin consumer database");
		return Arrays.asList(restTemplate.getForObject(ADDADMIN, Admin[].class));
	}

	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Fetching admin by id", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseInfo.class)) }),
			@ApiResponse(responseCode = "404", description = "Admin Not Found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorInfo.class)) }) })
	@Operation(summary = "Fetching admin from database by id")
	@GetMapping("/admins/{id}")
	Admin getAdmin(@PathVariable("id") int adminId, HttpServletRequest request) {
		logger.info("Getting admin by id from admin database using admin consumer database");
		return restTemplate.getForObject(ADMINBYID + adminId, Admin.class);
	}

	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Adding admin", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseInfo.class)) }),
			@ApiResponse(responseCode = "409", description = "Admin Already exists", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorInfo.class)) }) })
	@Operation(summary = "Adding admin to database")
	@PostMapping("/admins")
	ResponseEntity<ResponseInfo> addAdmin(@RequestBody Admin admin, HttpServletRequest request) {
		logger.info("Adding admins to admin database using admin consumer database");
		return restTemplate.postForEntity(ADDADMIN, admin, ResponseInfo.class);
	}

	@ApiResponses(value = {
			@ApiResponse(responseCode = "202", description = "Updating admin", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseInfo.class)) }),
			@ApiResponse(responseCode = "404", description = "Admin Not found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorInfo.class)) }) })
	@Operation(summary = "Updating admin in the database")
	@PutMapping("/admins")
	ResponseEntity<ResponseInfo> updateAdmin(@RequestBody Admin admin, HttpServletRequest request) {
		logger.info("Updating admins to admin database using admin consumer database");
		restTemplate.put(ADDADMIN, admin, ResponseInfo.class);
		String msg = "Admin Updated Successfully";
		ResponseInfo info = new ResponseInfo(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED.name(), msg,
				request.getRequestURI());
		return new ResponseEntity<>(info, HttpStatus.ACCEPTED);
	}

	@ApiResponses(value = {
			@ApiResponse(responseCode = "202", description = "Removing admin by id", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseInfo.class)) }),
			@ApiResponse(responseCode = "404", description = "Admin Not Found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorInfo.class)) }) })
	@Operation(summary = "Deleting admin from database by id")
	@DeleteMapping("/admins/{id}")
	ResponseEntity<ResponseInfo> removeAdmin(@PathVariable("id") int adminId, HttpServletRequest request) {
		logger.info("Deleting admin by id from admin database using admin consumer database");
		restTemplate.delete(ADMINBYID + adminId, ResponseInfo.class);
		String msg = "Admin Deleted Successfully";
		ResponseInfo info = new ResponseInfo(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED.name(), msg,
				request.getRequestURI());
		return new ResponseEntity<>(info, HttpStatus.ACCEPTED);
	}

	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Fetching all patients", content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ResponseInfo.class))) }) })
	@Operation(summary = "Fetching all the patients from the database")
	@GetMapping("/patients")
	List<Patient> getAllPatients(HttpServletRequest request) {
		logger.info("Getting All patients from patient database using admin consumer database");
		return Arrays.asList(restTemplate.getForObject(ADDPATIENT, Patient[].class));
	}

	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Fetching patient by id", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseInfo.class)) }),
			@ApiResponse(responseCode = "404", description = "Patient Not Found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorInfo.class)) }) })
	@Operation(summary = "Fetching patient from database by id")
	@GetMapping("/patients/{id}")
	Patient getPatient(@PathVariable("id") int patientId, HttpServletRequest request) {
		logger.info("Getting patient by id from patient database using admin consumer database");
		return restTemplate.getForObject(PATIENTBYID + patientId, Patient.class, ResponseInfo.class);
	}

	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Adding patient", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseInfo.class)) }),
			@ApiResponse(responseCode = "409", description = "Patient Already exists", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorInfo.class)) }) })
	@Operation(summary = "Adding patient to database")
	@PostMapping("/patients")
	ResponseEntity<ResponseInfo> addPatient(@RequestBody Patient patient, HttpServletRequest request) {
		logger.info("Adding patients to patient database using admin consumer database");
		return restTemplate.postForEntity(ADDPATIENT, patient, ResponseInfo.class);
	}

	@ApiResponses(value = {
			@ApiResponse(responseCode = "202", description = "Updating patient", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseInfo.class)) }),
			@ApiResponse(responseCode = "404", description = "Patient Not found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorInfo.class)) }) })
	@Operation(summary = "Updating patient in the database")
	@PutMapping("/patients")
	ResponseEntity<ResponseInfo> updatePatient(@RequestBody Patient patient, HttpServletRequest request) {
		logger.info("Updating patients to patient database using admin consumer database");
		restTemplate.put(ADDPATIENT, patient, ResponseInfo.class);
		String msg = "Patient Updated Successfully";
		ResponseInfo info = new ResponseInfo(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED.name(), msg,
				request.getRequestURI());
		return new ResponseEntity<>(info, HttpStatus.ACCEPTED);
	}

	@ApiResponses(value = {
			@ApiResponse(responseCode = "202", description = "Removing patient by id", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseInfo.class)) }),
			@ApiResponse(responseCode = "404", description = "Patient Not Found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorInfo.class)) }) })
	@Operation(summary = "Deleting patient from database by id")
	@DeleteMapping("/patients/{id}")
	ResponseEntity<ResponseInfo> removePatient(@PathVariable("id") int patientId, HttpServletRequest request) {
		logger.info("Deleting patients by id from patient database using admin consumer database");
		restTemplate.delete(PATIENTBYID + patientId, ResponseInfo.class);
		String msg = "Patient Deleted Successfully";
		ResponseInfo info = new ResponseInfo(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED.name(), msg,
				request.getRequestURI());
		return new ResponseEntity<>(info, HttpStatus.ACCEPTED);
	}

	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Fetching all doctors", content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ResponseInfo.class))) }) })
	@Operation(summary = "Fetching all the doctors from the database")
	@GetMapping("/doctors")
	List<Doctor> getAllDoctors(HttpServletRequest request) {
		logger.info("Getting All doctors from doctor database using admin consumer database");
		return Arrays.asList(restTemplate.getForObject(ADDDOCTOR, Doctor[].class, ResponseInfo.class));
	}

	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Fetching doctor by id", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseInfo.class)) }),
			@ApiResponse(responseCode = "404", description = "Doctor Not Found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorInfo.class)) }) })
	@Operation(summary = "Fetching doctor from database by id")
	@GetMapping("/doctors/{id}")
	Doctor getDoctor(@PathVariable("id") int doctorId, HttpServletRequest request) {
		logger.info("Getting doctors by id from doctor database using admin consumer database");
		return restTemplate.getForObject(DOCTORBYID + doctorId, Doctor.class, ResponseInfo.class);
	}

	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Adding doctor", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseInfo.class)) }),
			@ApiResponse(responseCode = "409", description = "Already exists", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorInfo.class)) }) })
	@Operation(summary = "Adding doctor to database")
	@PostMapping("/doctors")
	ResponseEntity<ResponseInfo> addDoctor(@RequestBody Doctor doctor, HttpServletRequest request) {
		logger.info("Adding doctors to doctor database using admin consumer database");
		return restTemplate.postForEntity(ADDDOCTOR, doctor, ResponseInfo.class);
	}

	@ApiResponses(value = {
			@ApiResponse(responseCode = "202", description = "Updating doctor", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseInfo.class)) }),
			@ApiResponse(responseCode = "404", description = "Doctor Not found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorInfo.class)) }) })
	@Operation(summary = "Updating doctor in the database")
	@PutMapping("/doctors")
	ResponseEntity<ResponseInfo> updateDoctor(@RequestBody Doctor doctor, HttpServletRequest request) {
		logger.info("Updating doctors to doctor database using admin consumer database");
		restTemplate.put(ADDDOCTOR, doctor, ResponseInfo.class);
		String msg = "Doctor Updated Successfully";
		ResponseInfo info = new ResponseInfo(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED.name(), msg,
				request.getRequestURI());
		return new ResponseEntity<>(info, HttpStatus.ACCEPTED);
	}

	@ApiResponses(value = {
			@ApiResponse(responseCode = "202", description = "Removing doctor by id", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseInfo.class)) }),
			@ApiResponse(responseCode = "404", description = "Doctor Not Found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorInfo.class)) }) })
	@Operation(summary = "Deleting doctor from database by id")
	@DeleteMapping("/doctors/{id}")
	ResponseEntity<ResponseInfo> removeDoctor(@PathVariable("id") int doctorId, HttpServletRequest request) {
		logger.info("Deleting doctors by id from doctor database using admin consumer database");
		restTemplate.delete(DOCTORBYID + doctorId, ResponseInfo.class);
		String msg = "Doctor Deleted Successfully";
		ResponseInfo info = new ResponseInfo(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED.name(), msg,
				request.getRequestURI());
		return new ResponseEntity<>(info, HttpStatus.ACCEPTED);
	}

	@ApiResponses(value = { @ApiResponse(responseCode = "202", description = "Changing appointment status", content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ResponseInfo.class))) }),
			@ApiResponse(responseCode = "409", description = "Appointment Not Found", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ErrorInfo.class))) }) })
	@Operation(summary = "Changing the appointment status by id")
	@PatchMapping("/appointments/{id}/appointmentStatus/{status}")
	public ResponseEntity<ResponseInfo> changeAppointmentStatus(@PathVariable("id") int appointmentId,
			@PathVariable("status") String status, HttpServletRequest httpServletRequest) {
		logger.info("Updating appointment status in the database");
//		ResponseInfo info = restTemplate.patchForObject(
//				GETAPPOINTMENT + appointmentId + "/appointmentStatus/" + status, null,
//				ResponseInfo.class);
//		if (status.equals("Declined")) {
//			Appointment appointment = restTemplate.getForObject(GETAPPOINTMENT + appointmentId,
//					Appointment.class);
//			int id = appointment.getDoctorId();
//			LocalDate date = appointment.getAppointmentDate();
//			AvailabilityDate availabilityDate = new AvailabilityDate();
//			availabilityDate.setDoctor(id);
//			availabilityDate.setDate(date);
//			restTemplate.postForEntity(REJECTAPPOINTMENT, availabilityDate, ResponseInfo.class);
//		}
//		return new ResponseEntity<>(info, HttpStatus.ACCEPTED);
		Appointment appointment = restTemplate.getForObject(GETAPPOINTMENT + appointmentId, Appointment.class);
		String message = "Not Updated";
		if(appointment!=null) {
			appointment.setAppointmentStatus(AppointmentStatus.valueOf(status));
			restTemplate.put(UPDATEAPPOINTMENT, appointment);
			message = "Appointment Status updated successfully";
			if (status.equals("Rejected")) {
				int id = appointment.getDoctorId();
				LocalDate date = appointment.getAppointmentDate();
				AvailabilityDate availabilityDate = new AvailabilityDate();
				availabilityDate.setDoctor(id);
				availabilityDate.setDate(date);
				restTemplate.postForEntity(ADDAVAILABILITY, availabilityDate, ResponseInfo.class);
			}
		}
		ResponseInfo info = new ResponseInfo(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED.name(), message, httpServletRequest.getRequestURI());
		return new ResponseEntity<>(info,HttpStatus.ACCEPTED);
		
	}
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Fetching all appointments", content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ResponseInfo.class))) }) })
	@Operation(summary = "Fetching all the appointments in the database")
	@GetMapping("/appointments")
	List<Appointment> getAllAppointments(HttpServletRequest request) {
		logger.info("Getting All appointments from appointment database using admin consumer database");
		return Arrays.asList(restTemplate.getForObject(ADDAPPOINTMENT, Appointment[].class, ResponseInfo.class));
	}

}
