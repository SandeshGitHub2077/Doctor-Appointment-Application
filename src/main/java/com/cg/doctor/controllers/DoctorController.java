package com.cg.doctor.controllers;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.doctor.entities.AvailabilityDate;
import com.cg.doctor.entities.Doctor;
import com.cg.doctor.services.DoctorService;

@RestController
public class DoctorController {

	Logger logger = LoggerFactory.getLogger(DoctorController.class);

	@Autowired
	private DoctorService doctorService;

	@PostMapping("/doctors")
	ResponseEntity<ResponseInfo> addDoctor(@Valid @RequestBody Doctor doctor, HttpServletRequest request) {
		logger.info("Add a new doctor to database");
		String message = doctorService.addDoctor(doctor);
		ResponseInfo responseInfo = new ResponseInfo(HttpStatus.CREATED.value(), HttpStatus.CREATED.name(), message,
				request.getRequestURI());
		return new ResponseEntity<>(responseInfo, HttpStatus.CREATED);
	}

	@PutMapping("/doctors")
	ResponseInfo updateDoctorProfile(@Valid @RequestBody Doctor doctor, HttpServletRequest request) {
		logger.info("Update a doctor's profile by Id");
		String message = doctorService.updateDoctorProfile(doctor);
		return new ResponseInfo(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED.name(), message,
				request.getRequestURI());
	}

	@GetMapping("/doctors/{id}")
	Doctor getDoctorById(@PathVariable("id") Integer id, HttpServletRequest request) {
		logger.info("Get doctor from database by Id");
		return doctorService.getDoctorById(id);
	}

	@DeleteMapping("/doctors/{id}")
	ResponseEntity<ResponseInfo> removeDoctorById(@PathVariable("id") Integer id, HttpServletRequest request) {
		logger.info("Remove a doctor's profile from database");
		String message = doctorService.removeDoctorById(id);
		ResponseInfo info = new ResponseInfo(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED.name(), message,
				request.getRequestURI());
		return new ResponseEntity<>(info, HttpStatus.ACCEPTED);
	}

	@GetMapping("/doctors")
	List<Doctor> getDoctorList(HttpServletRequest request) {
		logger.info("Get all doctors from database");
		return doctorService.getDoctorList();
	}

	@GetMapping("/doctors/speciality/{speciality}")
	List<Doctor> getDoctorListBySpeciality(@PathVariable("speciality") String speciality, HttpServletRequest request) {
		logger.info("Get the list of doctors from database based on speciality");
		return doctorService.getDoctorListBySpeciality(speciality);
	}

	@PostMapping("doctors/availabilityDates")
	ResponseEntity<ResponseInfo> addAvailability(@Valid @RequestBody AvailabilityDate availabilityDate,
			HttpServletRequest request) {
		logger.info("Add an availability date to the database");
		String message = doctorService.addAvailability(availabilityDate);
		ResponseInfo responseInfo = new ResponseInfo(HttpStatus.CREATED.value(), HttpStatus.CREATED.name(), message,
				request.getRequestURI());
		return new ResponseEntity<>(responseInfo, HttpStatus.CREATED);

	}

	@PutMapping("doctors/availabilityDates")
	ResponseEntity<ResponseInfo> updateAvailability(@Valid @RequestBody AvailabilityDate availabilityDates,
			HttpServletRequest request) {
		logger.info("update availability dates based on availability id");
		String message = doctorService.updateAvailability(availabilityDates);
		ResponseInfo info = new ResponseInfo(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED.name(), message,
				request.getRequestURI());
		return new ResponseEntity<>(info, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("doctors/availabilityDates/{id}")
	ResponseEntity<ResponseInfo> removeAvailabilityById(@PathVariable("id") Integer id, HttpServletRequest request) {
		logger.info("Remove the availability from the database");
		String message = doctorService.removeAvailabilityDatesById(id);
		ResponseInfo info = new ResponseInfo(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED.name(), message,
				request.getRequestURI());
		return new ResponseEntity<>(info, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/doctors/availabilityDates/{id}")
	List<AvailabilityDate> getAvailabilityDatesById(@PathVariable("id") Integer doctorId, HttpServletRequest request){
		return doctorService.getAllAvailabilityDatesByDoctorId(doctorId);
	}

}
