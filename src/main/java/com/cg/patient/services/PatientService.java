package com.cg.patient.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.patient.entities.Patient;
import com.cg.patient.exceptions.IdNotFoundException;
import com.cg.patient.exceptions.PatientAlreadyExistsException;
import com.cg.patient.repositories.PatientJpaRepository;

@Service
@Transactional
public class PatientService {
	Logger logger= LoggerFactory.getLogger(PatientService.class);
	@Autowired
	private PatientJpaRepository patientRepository;
	
	public String addPatient(Patient patient){
		logger.info("Inside add patinet service method");
		if(!(patientRepository.findByUserName(patient.getUserName()).isPresent())) {
			logger.info("inside add patient service method ----> data base doesn't contain the patinet");
			patientRepository.save(patient);
			logger.info("inside add patinet service method ----> patient is added into the data base");
			return "Patient added successfully!!!";

		}
		else {
			logger.error("inside add patient service method ----> data base already contains the patient");
			throw new PatientAlreadyExistsException( "Patinet Already exists for the userName "+patient.getUserName());//exception rayali
		}
	}
	public String updatePatient(Patient patient){
		logger.info("inside update patient service method");
		if(patientRepository.findById(patient.getPatientId()).isPresent()) {
			patientRepository.save(patient);
			logger.info("inside update patient service method ----> patient has been updated successfully");
			return "Patient updated successfully!!!";
		}
		else {
			logger.info("inside update patient service method ----> data base doesn't contain the patient");
			throw new  IdNotFoundException("No record found for this id: "+patient.getPatientId());
		}
	}
	public String deletePatientById(int patientId){
		logger.info("inside delete patient by patientId service method");
		Optional<Patient> patient=patientRepository.findById(patientId);
		if(patient.isPresent()) {
			patientRepository.deleteById(patientId);
			logger.info("inside delete patient by patientId service method ----> patient has been successfully deleted");
			return "Deleted patient record successfully!!!";
		}
		else {
			logger.error("inside delete patient by patientId service method ----> data base doesn't contain the patient");
			throw new IdNotFoundException("No Record found for this id: "+patientId);
		}
	}
	public Patient getPatientById(int patientId){
		logger.info("inside get patient by patentId service method");
		Optional<Patient> patient=patientRepository.findById(patientId);
		if(patient.isPresent()) {
			logger.info("inside get patient by patientId service method ----> data base contains the patient");
			logger.info("inside get patient by patientId service method ----> returning the paatienr object");
			return patient.get();
		}
		else {
			logger.error("inside get patient by patientId service method ----> data base doesn't contain the patient");
			throw new IdNotFoundException("No Record found for this id: "+patientId);
		}
	}
	public List<Patient> getAllPatients() {
		logger.info("inside get all patients service method");
		logger.info("inside get all patients service method -----> returning all the patients from the data base");
		return patientRepository.findAll();
	}
}