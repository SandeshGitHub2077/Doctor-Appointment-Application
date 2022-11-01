package com.cg.patient.controllers;

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

import com.cg.patient.entities.Patient;
import com.cg.patient.services.PatientService;

/**
 * 
 * @author Issarapu Gangadhar Controller class for Patient,can perform add
 *         patient,delete patient,update patient,get patient
 * 
 */
@RestController
//req
public class PatientController {
	/**
	 * Logger file to log the information
	 */
	Logger logger = LoggerFactory.getLogger(PatientController.class);

	/**
	 * Patient service field is used to perform bussing logic for adding patient,
	 * deleting patient ,updating patient, getting patient
	 */
	@Autowired
	private PatientService patientService;

	@PostMapping("/patients")
	public ResponseEntity<ResponseInfo> addPatient(@Valid @RequestBody Patient patient, HttpServletRequest request) {
		logger.info("Inside add patient contoller method");
		String message = patientService.addPatient(patient);
		ResponseInfo responseInfo = new ResponseInfo(HttpStatus.CREATED.value(), HttpStatus.CREATED.name(), message,
				request.getRequestURI());
		return new ResponseEntity<>(responseInfo, HttpStatus.CREATED);
	}

	@PutMapping("/patients")
	public ResponseEntity<ResponseInfo> updatePatient(@Valid @RequestBody Patient patient, HttpServletRequest request) {
		logger.info("inside update patient controller method");
		String message = patientService.updatePatient(patient);
		ResponseInfo responseInfo = new ResponseInfo(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED.name(), message,
				request.getRequestURI());
		return new ResponseEntity<>(responseInfo, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/patients/{id}")
	public ResponseEntity<ResponseInfo> deletePatientById(@PathVariable("id") int patientId,
			HttpServletRequest request) {
		logger.info("Inside delete patient by patientId controller method");
		String message = patientService.deletePatientById(patientId);
		ResponseInfo rinfo = new ResponseInfo(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED.name(), message,
				request.getRequestURI());
		return new ResponseEntity<>(rinfo, HttpStatus.ACCEPTED);
	}

	@GetMapping("/patients/{id}")
	public Patient getPatientById(@PathVariable("id") int patientId) {
		logger.info("Inside get patient by patientId controller method");
		return patientService.getPatientById(patientId);
	}

	@GetMapping("/patients")
	public List<Patient> getAllPatients() {
		logger.info("Inside get all patients controller method");
		return patientService.getAllPatients();
	}
}