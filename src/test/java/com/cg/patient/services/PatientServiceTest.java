package com.cg.patient.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.patient.entities.Patient;
import com.cg.patient.exceptions.IdNotFoundException;
import com.cg.patient.exceptions.PatientAlreadyExistsException;
import com.cg.patient.repositories.PatientJpaRepository;

@SpringBootTest(classes= {PatientServiceTest.class})
class PatientServiceTest {
	@Mock
	PatientJpaRepository patientRepository;
	
	@InjectMocks
	PatientService patientService;
	
	@Test
	void addPatientTest() {
		Patient patient = new Patient(1,"aravind","9876543219","aravind@capgemini.com","A +ve","male",25,"ABD road,Surampalem","gfvvbn","asr");
		Optional<Patient> optionalPatient = Optional.empty();
		when(patientRepository.findByUserName(patient.getUserName())).thenReturn(optionalPatient);
		when(patientRepository.save(patient)).thenReturn(patient);//Mocking
		assertEquals("Patient added successfully!!!",patientService.addPatient(patient));
		verify(patientRepository,times(1)).findByUserName(patient.getUserName());
		verify(patientRepository,times(1)).save(patient);
	}
	
	@Test
	void addPatientFailTest() {
		Patient patient = new Patient(1,"aravind","9876543219","aravind@capgemini.com","A +ve","male",25,"ABD road,Surampalem","gfvvbn","asr");
		Optional<Patient> optionalPatient = Optional.empty();
		when(patientRepository.findByUserName(patient.getUserName())).thenReturn(Optional.of(patient));
		when(patientRepository.save(patient)).thenReturn(patient);
		assertThrows(PatientAlreadyExistsException.class,()->{patientService.addPatient(patient);});
		verify(patientRepository,times(1)).findByUserName(patient.getUserName());
		verify(patientRepository,times(0)).save(patient);
	}
	
	@Test
	void updatePatientTest() {
		Patient patient = new Patient(1,"aravind","9876543219","aravind@capgemini.com","A +ve","male",25,"ABD road,Surampalem","gfvvbn","asr");
		Optional<Patient> optionalPatient = Optional.empty();
		when(patientRepository.findById(patient.getPatientId())).thenReturn(Optional.of(patient));
		when(patientRepository.save(patient)).thenReturn(patient);
		assertEquals("Patient updated successfully!!!",patientService.updatePatient(patient));
		verify(patientRepository,times(1)).findById(patient.getPatientId());
		verify(patientRepository,times(1)).save(patient);
	}
	
	@Test
	void updatePatientFailTest() {
		Patient patient = new Patient(1,"aravind","9876543219","aravind@capgemini.com","A +ve","male",25,"ABD road,Surampalem","gfvvbn","asr");
		when(patientRepository.findById(patient.getPatientId())).thenReturn(Optional.empty());
		when(patientRepository.save(patient)).thenReturn(patient);
		assertThrows(IdNotFoundException.class,()->{patientService.updatePatient(patient);});
		verify(patientRepository,times(1)).findById(patient.getPatientId());
		verify(patientRepository,times(0)).save(patient);
	}
	
	@Test
	void deletePatientByIdTest() {
		Patient patient = new Patient(1,"aravind","9876543219","aravind@capgemini.com","A +ve","male",25,"ABD road,Surampalem","gfvvbn","asr");
		when(patientRepository.findById(patient.getPatientId())).thenReturn(Optional.of(patient));
		patientService.deletePatientById(patient.getPatientId());
		verify(patientRepository,times(1)).deleteById(patient.getPatientId());

	}
	
	@Test
	void deletePatientByIdFaliTest() {
		Patient patient = new Patient(1,"aravind","9876543219","aravind@capgemini.com","A +ve","male",25,"ABD road,Surampalem","gfvvbn","asr");
		when(patientRepository.findById(patient.getPatientId())).thenReturn(Optional.empty());
		int id = patient.getPatientId();
		assertThrows(IdNotFoundException.class,()->patientService.deletePatientById(id));
		verify(patientRepository,times(1)).findById(patient.getPatientId());
	}
	
	@Test
	void getPatientByIdTest() {
		Patient patient = new Patient(1,"aravind","9876543219","aravind@capgemini.com","A +ve","male",25,"ABD road,Surampalem","gfvvbn","asr");
		when(patientRepository.findById(patient.getPatientId())).thenReturn(Optional.of(patient));
		when(patientRepository.save(patient)).thenReturn(patient);
		assertEquals(patient, patientService.getPatientById(patient.getPatientId()));
		verify(patientRepository,times(1)).findById(patient.getPatientId());
	}
	
	@Test
	void  getPatientByIdFailTest() {
		Patient patient = new Patient(1,"aravind","9876543219","aravind@capgemini.com","A +ve","male",25,"ABD road,Surampalem","gfvvbn","asr");
		when(patientRepository.findById(patient.getPatientId())).thenReturn(Optional.empty());
		int id = patient.getPatientId();
		assertThrows(IdNotFoundException.class, ()->patientService.getPatientById(id));
		verify(patientRepository,times(1)).findById(patient.getPatientId());
	}
	
	@Test
	 void getAllPatientsTest() {
		 List<Patient> patient=new ArrayList<>();
		 patient.add(new Patient(1,"aravind","9876543219","aravind@capgemini.com","A +ve","male",25,"ABD road,Surampalem","gfvvbn","asr"));
		 patient.add(new Patient(2,"trendsetter","8876543278","trendsetter@capgemini.com","B -ve","female",24,"ABD road,Peddapuram","gfvvbn","asr"));
		when(patientRepository.findAll()).thenReturn(patient);
		assertEquals(patient,patientService.getAllPatients());
		verify(patientRepository,times(1)).findAll();
	 }
}
