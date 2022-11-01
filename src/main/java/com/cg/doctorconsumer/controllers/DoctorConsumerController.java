package com.cg.doctorconsumer.controllers;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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

import com.cg.doctorconsumer.constants.ConstantStrings;
import com.cg.doctorconsumer.dto.Appointment;
import com.cg.doctorconsumer.dto.AvailabilityDate;
import com.cg.doctorconsumer.dto.Doctor;
import com.cg.doctorconsumer.dto.FeedBack;
import com.cg.doctorconsumer.dto.Patient;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

/**
 * 
 * @author Aikya Sri Jajimoggala, Kambala Niteesh Kumar Controller class for
 *         Doctor consumer. Can perform add doctor, update doctor, get doctor,
 *         remove doctor, get all doctors, get all doctors by speciality, add
 *         availability, update availability, get all appointments for doctor,
 *         get appointment list by date, get appointment status, get all
 *         patients for doctor, reject appointment, get feedback by id get
 *         feedbacks for doctor
 */

@RestController
@RequestMapping("/doctorconsumer")
public class DoctorConsumerController {
	Logger logger = LoggerFactory.getLogger(DoctorConsumerController.class);

	@Autowired
	RestTemplate restTemplate;

	/**
	 * 
	 * @param doctor
	 * @param httpServletRequest
	 * @return Adds doctor to the database if not present else throws exception
	 */
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Adding doctor", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseInfo.class)) }),
			@ApiResponse(responseCode = "409", description = "Already exists", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorInfo.class)) }) })
	@Operation(summary = "Adding doctor to database")
	@PostMapping("/doctors")
	public ResponseEntity<ResponseInfo> addDoctor(@RequestBody Doctor doctor, HttpServletRequest httpServletRequest) {
		logger.info("Adding doctor to database");
		return restTemplate.postForEntity(ConstantStrings.ADD_DOCTOR, doctor, ResponseInfo.class);
	}

	/**
	 * 
	 * @param doctor
	 * @param httpServletRequest
	 * @return Updates the doctor in the database if present else throws exception
	 */
	@ApiResponses(value = {
			@ApiResponse(responseCode = "202", description = "Updating doctor", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseInfo.class)) }),
			@ApiResponse(responseCode = "404", description = "Doctor Not found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorInfo.class)) }) })
	@Operation(summary = "Updating doctor in the database")
	@PutMapping("/doctors")
	public ResponseEntity<ResponseInfo> updateDoctorProfile(@RequestBody Doctor doctor,
			HttpServletRequest httpServletRequest) {
		logger.info("Updating doctor in the database");
		restTemplate.put(ConstantStrings.UPDATE_DOCTOR, doctor);
		String message = "Doctor Updated Successfuly";
		ResponseInfo info = new ResponseInfo(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED.name(), message,
				httpServletRequest.getRequestURI());
		return new ResponseEntity<>(info, HttpStatus.ACCEPTED);
	}

	/**
	 * 
	 * @param availabilityDate
	 * @param httpServletRequest
	 * @return adds availability to the database
	 */
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Adding availability", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseInfo.class)) }),
			@ApiResponse(responseCode = "409", description = "Already exists", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorInfo.class)) }) })
	@Operation(summary = "Adding availability to the database")
	@PostMapping("/doctors/availabilityDate")
	public ResponseEntity<ResponseInfo> addAvailability(@RequestBody AvailabilityDate availabilityDate,
			HttpServletRequest httpServletRequest) {
		logger.info("Adding availability to the database");
		return restTemplate.postForEntity(ConstantStrings.ADD_AVAILABILITY, availabilityDate, ResponseInfo.class);
	}

	/**
	 * 
	 * @param availabilityDate
	 * @param httpServletRequest
	 * @return Updates availability in the database if present else throws exception
	 */
	@ApiResponses(value = {
			@ApiResponse(responseCode = "202", description = "Updating availability", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseInfo.class)) }),
			@ApiResponse(responseCode = "404", description = "Availability Not found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorInfo.class)) }) })
	@Operation(summary = "Updating availability in the database")
	@PutMapping("/doctors/availabilityDate")
	public ResponseEntity<ResponseInfo> updateAvailability(@RequestBody AvailabilityDate availabilityDate,
			HttpServletRequest httpServletRequest) {
		logger.info("Updating availability in the database");
		restTemplate.put(ConstantStrings.UPDATE_AVAILABILITY, availabilityDate, ResponseInfo.class);
		String message = "Doctor Availabilty date Updated Successfuly";
		ResponseInfo info = new ResponseInfo(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED.name(), message,
				httpServletRequest.getRequestURI());
		return new ResponseEntity<>(info, HttpStatus.ACCEPTED);
	}

	/**
	 * 
	 * @param doctorId
	 * @param httpServletRequest
	 * @return Fetches the doctor by id from the database else throws exception
	 */
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Fetching doctor", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseInfo.class)) }),
			@ApiResponse(responseCode = "404", description = "Doctor Not Found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorInfo.class)) }) })
	@Operation(summary = "Fetching doctor from database by id")
	@GetMapping("/doctors/{id}")
	public Doctor getDoctor(@PathVariable("id") int doctorId, HttpServletRequest httpServletRequest) {
		logger.info("Fetching doctor from the database");
		return restTemplate.getForObject(ConstantStrings.GET_DOCTOR + doctorId, Doctor.class);
	}

	/**
	 * 
	 * @param doctorId
	 * @param httpServletRequest
	 * @return deletes doctor from the database if present else throws exception
	 */
	@ApiResponses(value = {
			@ApiResponse(responseCode = "202", description = "Removing doctor", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseInfo.class)) }),
			@ApiResponse(responseCode = "404", description = "Doctor Not Found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorInfo.class)) }) })
	@Operation(summary = "Deleting doctor from database by id")
	@DeleteMapping("/doctors/{id}")
	public ResponseEntity<ResponseInfo> deleteDoctor(@PathVariable("id") int doctorId,
			HttpServletRequest httpServletRequest) {
		logger.info("Deleting doctor from the database");
		restTemplate.delete(ConstantStrings.DELETE_DOCTOR + doctorId);
		String message = "Doctor Deleted Successfuly";
		ResponseInfo info = new ResponseInfo(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED.name(), message,
				httpServletRequest.getRequestURI());
		return new ResponseEntity<>(info, HttpStatus.ACCEPTED);
	}

	/**
	 * 
	 * @param httpServletRequest
	 * @return fetches all the doctors in the database
	 */
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Fetching all doctors", content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ResponseInfo.class))) }) })
	@Operation(summary = "Fetching all the doctors in the database")
	@GetMapping("/doctors")
	public List<Doctor> getAllDoctors(HttpServletRequest httpServletRequest) {
		logger.info("Fetching all the doctors in the database");
		return Arrays.asList(restTemplate.getForObject(ConstantStrings.GET_ALL_DOCTORS, Doctor[].class));
	}

	/**
	 * 
	 * @param speciality
	 * @param httpServletRequest
	 * @return fetches all the doctors related to given specialty from the database
	 *         if present else throws exception
	 */
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Fetching all doctors by speciality", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ResponseInfo.class))) }),
			@ApiResponse(responseCode = "404", description = "Speciality Not Found", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ErrorInfo.class))) }) })
	@Operation(summary = "Fetching all the doctors related to given speciality from the database")
	@GetMapping("/doctors/speciality/{speciality}")
	public List<Doctor> getDoctorListBySpeciality(@PathVariable("speciality") String speciality,
			HttpServletRequest httpServletRequest) {
		logger.info("Fetching all doctors based on speciality");
		return Arrays.asList(
				restTemplate.getForObject(ConstantStrings.GET_DOCTORS_BY_SPECIALITY + speciality, Doctor[].class));
	}

	/**
	 * 
	 * @param date
	 * @param httpServletRequest
	 * @return fetches all the appointments on a given date if present else throws
	 *         an exception
	 */
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Fetching appointments by date", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ResponseInfo.class))) }),
			@ApiResponse(responseCode = "404", description = "Appointment Not Found", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ErrorInfo.class))) }) })
	@Operation(summary = "")
	@GetMapping("/appointments/appointmentDate/{date}")
	public List<Appointment> getAppointmentListByDate(@PathVariable("date") String date,
			HttpServletRequest httpServletRequest) {
		logger.info("Fetching list of appointments based on date");
		return Arrays.asList(
				restTemplate.getForObject(ConstantStrings.GET_APPOINTMENTS_BY_DATE + date, Appointment[].class));
	}

	/**
	 * 
	 * @param doctorId
	 * @param httpServletRequest
	 * @return fetches a list of appointments of a doctor if present from the
	 *         database else throws exception
	 */
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Fetching all appointments for doctor", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ResponseInfo.class))) }),
			@ApiResponse(responseCode = "404", description = "Doctor Not Found", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ErrorInfo.class))) }) })
	@Operation(summary = "Fetching list of appointments for a doctor")
	@GetMapping("/appointments/doctorId/{did}")
	public List<Appointment> getAllAppointmnetsForDoctor(@PathVariable("did") int doctorId,
			HttpServletRequest httpServletRequest) {
		logger.info("Fetching all the appointments for a doctor");
		return Arrays.asList(
				restTemplate.getForObject(ConstantStrings.GET_APPOINTMENTS_FOR_DOCTOR + doctorId, Appointment[].class));
	}

	/**
	 * 
	 * @param appointmentId
	 * @param httpServletRequest
	 * @return fetches appointment status from the database if present else throws
	 *         exception
	 */
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Fetching appointment status", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseInfo.class)) }),
			@ApiResponse(responseCode = "404", description = "Appointment Not Found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorInfo.class)) }) })
	@Operation(summary = "Fetching appointment status by id")
	@GetMapping("/appointments/{id}")
	public ResponseEntity<ResponseInfo> getAppointmentStatus(@PathVariable("id") int appointmentId,
			HttpServletRequest httpServletRequest) {
		logger.info("Fetching the appointment status of an appointment");
		return restTemplate.getForEntity(ConstantStrings.GET_APPOINTMENT_STATUS + appointmentId, ResponseInfo.class);
	}

	/**
	 * 
	 * @param appointmentId
	 * @param status
	 * @param httpServletRequest
	 * @return changes appointment status in the database if present else throws
	 *         exceptions
	 */
	@ApiResponses(value = {
			@ApiResponse(responseCode = "202", description = "Changing appointment status", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseInfo.class)) }),
			@ApiResponse(responseCode = "409", description = "Appointment Not Found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorInfo.class)) }) })
	@Operation(summary = "Changing the appointment status by id")
	@PatchMapping("/appointments/{id}/appointmentStatus/{status}")
	public ResponseEntity<ResponseInfo> changeAppointmentStatus(@PathVariable("id") int appointmentId,
			@PathVariable("status") String status, HttpServletRequest httpServletRequest) {
		logger.info("Updating appointment status in the database");
		Appointment appointment = restTemplate.getForObject(ConstantStrings.GET_APPOINTMENT + appointmentId, Appointment.class);
		String message = "Status Not Updated";
		if (appointment != null) {
			appointment.setAppointmentStatus(status);
			restTemplate.put(ConstantStrings.CHANGE_APPOINTMENT_STATUS, appointment);
			message = "Status Updated Successfully";
			if (status.equals("Declined")) {
				int id = appointment.getDoctorId();
				LocalDate date = appointment.getAppointmentDate();
				AvailabilityDate availabilityDate = new AvailabilityDate();
				availabilityDate.setDoctor(id);
				availabilityDate.setDate(date.toString());
				restTemplate.postForEntity(ConstantStrings.ADD_AVAILABILITY, availabilityDate, ResponseInfo.class);
			}
		}
		ResponseInfo info = new ResponseInfo(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED.name(), message,
				httpServletRequest.getRequestURI());
		return new ResponseEntity<>(info, HttpStatus.ACCEPTED);
	}

	/**
	 * 
	 * @param doctorId
	 * @param httpServletRequest
	 * @return fetches all patients related to a doctor if present from the database
	 *         else throws exception
	 */
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Fetching all patients for a doctor", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ResponseInfo.class))) }),
			@ApiResponse(responseCode = "404", description = "Doctor Not Found", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ErrorInfo.class))) }) })
	@Operation(summary = "Fetching all patients related to a doctor")
	@GetMapping("/appointments/patients/doctorId/{did}")
	public Set<Patient> getAllPatientsForDoctor(@PathVariable("did") int doctorId,
			HttpServletRequest httpServletRequest) {
		logger.info("Fetching all patients by doctor Id");
		Set<Patient> patientList = new LinkedHashSet<>();
		List<Appointment> appointmentList = getAllAppointmnetsForDoctor(doctorId, httpServletRequest);
		for (Appointment appointment : appointmentList) {
			patientList.add(restTemplate.getForObject(
					ConstantStrings.GET_ALL_PATIENTS_FOR_DOCTOR + appointment.getPatientId(), Patient.class));
		}
		return patientList;
	}

	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Fetching feedback by feedback Id", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ResponseInfo.class))) }),
			@ApiResponse(responseCode = "404", description = "Feedback Not Found", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ErrorInfo.class))) }) })
	@Operation(summary = "Fetching feedback by Id")
	@GetMapping("/feedbacks/{fid}")
	public FeedBack getFeedBackById(@PathVariable("fid") int feedbackId) {
		logger.info("Fetching the feedback by Id");
		return restTemplate.getForObject(ConstantStrings.GET_FEEDBACK_BY_ID + feedbackId, FeedBack.class);
	}

	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Fetching all feedbacks for a doctor", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ResponseInfo.class))) }),
			@ApiResponse(responseCode = "404", description = "Doctor Not Found", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ErrorInfo.class))) }) })
	@Operation(summary = "Fetching All feedbacks by doctorId")
	@GetMapping("/feedbacks/doctorId/{doctorId}")
	public List<FeedBack> getFeedBacksForDoctor(@PathVariable("doctorId") int doctorId) {
		logger.info("Fetching all feedbacks for a doctor");
		return Arrays.asList(
				restTemplate.getForObject(ConstantStrings.GET_FEEDBACKS_FOR_DOCTOR + doctorId, FeedBack[].class));
	}
}
