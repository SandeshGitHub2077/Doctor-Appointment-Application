package com.cg.appointment.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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

import com.cg.appointment.entities.Appointment;
import com.cg.appointment.entities.AppointmentStatus;
import com.cg.appointment.services.AppointmentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

/**
 * 
 * @author B.Rishita
 * 
 *
 */
@RestController
@RequestMapping("/appointments")
public class AppointmentController {

	/**
	 * Logger file to log the information
	 */

	Logger logger = LoggerFactory.getLogger(AppointmentController.class);

	/**
	 * Appointment Service field is used to perform business logic for adding
	 * appointment, deleting appointment, getting all appointments, updating status
	 */
	@Autowired
	private AppointmentService appointmentService;

	/**
	 * 
	 * @param request HttpServletRequest type object to get the information about
	 *                the list of appointments
	 * @return List type of all appointments
	 */

	@Operation(summary = "All Appointment Details are fetched")
	@GetMapping("")
	List<Appointment> fetchAllAppointments(HttpServletRequest request) {

		logger.info("Getting List Of all Appointments");
		return appointmentService.getAllAppointments();
	}

	/**
	 * 
	 * @param id      Id Entity is used to get the appointment details with that id
	 * @param request HttpServletRequest type object to get the information about
	 *                the appointment with the given Id
	 * @return Appointment type object with details of appointment with given Id
	 */

	@ApiResponses(value = {
			@ApiResponse(responseCode = "404", description = "This id is not found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorInfo.class)) }),
			@ApiResponse(responseCode = "200", description = "Appointment Entity Data", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Appointment.class)) }) })
	@Operation(summary = "Appointment Details are fetched on the basis of appointment Id")
	@GetMapping("/{id}")
	Appointment fetchAppointmentById(@PathVariable("id") int id, HttpServletRequest request) {

		logger.info("Getting Appointment Details By Appointment Id");
		return appointmentService.getAppointmentById(id);

	}

	/**
	 * 
	 * @param DId     Doctor Id is used to get the list of all appointments of the
	 *                doctor Id
	 * @param request HttpServletRequest type object to get the information about
	 *                the appointments with the given Doctor Id
	 * @return List of all appointments for the given doctor Id
	 */

	@ApiResponses(value = {
			@ApiResponse(responseCode = "404", description = "This id is not found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorInfo.class)) }),
			@ApiResponse(responseCode = "200", description = "Appointment Entity Data", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Appointment.class)) }) })

	@Operation(summary = "Appointment Details are fetched on the basis of doctor Id")
	@GetMapping("/doctorId/{DId}")
	List<Appointment> getAppointmentListByDoctorId(@PathVariable("DId") int DId, HttpServletRequest request) {

		logger.info("Getting Appointment Details By Doctor Id");
		return appointmentService.getAppointmentListByDoctorId(DId);

	}

	/**
	 * 
	 * @param PId     Patient Id is used to get the list of all appointments of the
	 *                doctor Id
	 * @param request HttpServletRequest type object to get the information about
	 *                the appointments with the given Patient Id
	 * @return List of all appointments for the given Patient Id
	 */

	@ApiResponses(value = {
			@ApiResponse(responseCode = "404", description = "This id is not found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorInfo.class)) }),
			@ApiResponse(responseCode = "200", description = "Appointment Entity Data", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Appointment.class)) }) })

	@Operation(summary = "Appointment Details are fetched on the basis of patient Id")
	@GetMapping("/patientId/{PId}")
	List<Appointment> getAppointmentListByPatientId(@PathVariable("PId") int PId, HttpServletRequest request) {

		logger.info("Getting Appointment Details By Patient Id");
		return appointmentService.getAppointmentListByPatientId(PId);
	}

	/**
	 * 
	 * @param id      Id Entity is used to get the status details with that id
	 * @param request HttpServletRequest type object to get the status of the given
	 *                Id
	 * @return ResponseInfo object as an ResponseEntity, contains HttpStatus
	 *         information
	 */

	@ApiResponses(value = {
			@ApiResponse(responseCode = "404", description = "This id is not found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorInfo.class)) }),
			@ApiResponse(responseCode = "200", description = "Appointment Entity Data", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Appointment.class)) }) })

	@Operation(summary = "Appointment Details are fetched on the basis of appointment status")
	@GetMapping("/status/{id}")
	ResponseEntity<ResponseInfo> getAppointmentStatusById(@PathVariable("id") int id, HttpServletRequest request) {

		AppointmentStatus status = appointmentService.getAppointmentStatusById(id);
		ResponseInfo responseInfo = new ResponseInfo(HttpStatus.CREATED.value(), HttpStatus.CREATED.name(),
				status.toString(), request.getRequestURI());
		return new ResponseEntity<>(responseInfo, HttpStatus.OK);
	}

	/**
	 * 
	 * @param appointment Appointment object will be added
	 * @param request     HttpServletRequest type object to get the information of
	 *                    request headers
	 * @return ResponseInfo object as an ResponseEntity, contains HttpStatus
	 *         information
	 */

	@Operation(summary = "Appointment Details are added into the database")
	@PostMapping("")
	ResponseEntity<ResponseInfo> insertAppointment(@Valid @RequestBody Appointment appointment,
			HttpServletRequest request) {

		logger.info("Inserting a new Appointment");
		System.out.println(appointment);
		String message = appointmentService.addAppointment(appointment);
		ResponseInfo responseInfo = new ResponseInfo(HttpStatus.CREATED.value(), HttpStatus.CREATED.name(), message,
				request.getRequestURI());
		return new ResponseEntity<>(responseInfo, HttpStatus.CREATED);
	}

	/**
	 * 
	 * @param id      Id Entity is used to get the status details with that id
	 * @param status  Status details are fetched to change the status
	 * @param request HttpServletRequest type object to get the information of
	 *                request headers
	 * @return ResponseInfo object as an ResponseEntity, contains HttpStatus
	 *         information
	 */
	@ApiResponses(value = {
			@ApiResponse(responseCode = "404", description = "This id is not found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorInfo.class)) }),
			@ApiResponse(responseCode = "200", description = "Appointment Entity Data", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Appointment.class)) }) })

	@Operation(summary = "Appointment status is updated on the basis of appointment Id")
	@PatchMapping("/{id}/appointmentStatus/{status}")
	ResponseEntity<ResponseInfo> changeStatus(@Valid @PathVariable("id") int id,
			@PathVariable("status") AppointmentStatus status, HttpServletRequest request) {

		logger.info("Updating status by Appointment Id");
		String message = appointmentService.changeStatus(id, status);
		ResponseInfo responseInfo = new ResponseInfo(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED.name(), message,
				request.getRequestURI());
		return new ResponseEntity<>(responseInfo, HttpStatus.ACCEPTED);

	}
	
	@PutMapping("")
	ResponseEntity<ResponseInfo> updateAppointmemt(@Valid @RequestBody Appointment appointment, HttpServletRequest request){
		System.out.println(appointment);
		String message = appointmentService.updateAppointment(appointment);
		ResponseInfo responseInfo = new ResponseInfo(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED.name(), message,
				request.getRequestURI());
		return new ResponseEntity<>(responseInfo, HttpStatus.ACCEPTED);
	}

	/**
	 * 
	 * @param id      Id Entity is used to get the appointment details with that id
	 * @param request HttpServletRequest type object to get the information of
	 *                request headers
	 * @return ResponseInfo object as an ResponseEntity, contains HttpStatus
	 *         information
	 */

	@ApiResponses(value = {
			@ApiResponse(responseCode = "404", description = "This id is not found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorInfo.class)) }),
			@ApiResponse(responseCode = "200", description = "Appointment Entity Data", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Appointment.class)) }) })

	@Operation(summary = "Appointment Details are deleted on the basis of appointment Id")
	@DeleteMapping("/{id}")
	ResponseEntity<ResponseInfo> deleteAppointmentById(@PathVariable("id") int id, HttpServletRequest request) {

		logger.info("Deleting appointment by Id");
		String message = appointmentService.deleteAppointmentById(id);
		ResponseInfo responseInfo = new ResponseInfo(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED.name(), message,
				request.getRequestURI());
		return new ResponseEntity<>(responseInfo, HttpStatus.ACCEPTED);
	}

	/**
	 * 
	 * @param date    Date Entity is used to get the appointments with the date
	 * @param request HttpServletRequest type object to get the information of
	 *                request headers
	 * @return List type is returned with all the appointments on the given date
	 */

	@ApiResponses(value = {
			@ApiResponse(responseCode = "404", description = "This Date is not found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorInfo.class)) }),
			@ApiResponse(responseCode = "200", description = "Appointment Entity Data", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Appointment.class)) }) })

	@Operation(summary = "Appointment Details are fetched on the basis of appointment Date")
	@GetMapping("/appointmentDate/{date}")
	List<Appointment> getAppointmentListByDate(@PathVariable("date") String date, HttpServletRequest request) {

		logger.info("Getting Appointment Details By Doctor Id");
		return appointmentService.getAppointmentListByDate(LocalDate.parse(date));
	}

}
