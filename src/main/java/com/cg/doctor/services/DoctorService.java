package com.cg.doctor.services;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.doctor.entities.AvailabilityDate;
import com.cg.doctor.entities.Doctor;
import com.cg.doctor.exceptions.AvailabilityExistsException;
import com.cg.doctor.exceptions.AvailabilityNotFoundException;
import com.cg.doctor.exceptions.DoctorAlreadyPresentException;
import com.cg.doctor.exceptions.DoctorNotFoundException;
import com.cg.doctor.exceptions.IdnotFoundException;
import com.cg.doctor.exceptions.SpecialityNotFoundException;
import com.cg.doctor.repositories.AvailabilityDatesRepository;
import com.cg.doctor.repositories.DoctorRepository;

@Service
@Transactional
public class DoctorService {

	Logger logger = LoggerFactory.getLogger(DoctorService.class);

	@Autowired
	private DoctorRepository doctorRepository;
	@Autowired
	private AvailabilityDatesRepository availabilityDatesRepository;

	public String addDoctor(Doctor doctor) {
		logger.info("inside add doctor service method");
		Optional<Doctor> optionalDoctor = doctorRepository.findByUserName(doctor.getUserName());
		if (!optionalDoctor.isPresent()) {
			logger.info("inside add doctor service method ----> data base doesn't contain the doctor");
			doctorRepository.save(doctor);
			logger.info("inside add doctor service method ----> doctor is added to data base");
			return "Doctor added successfully!";
		} else {
			logger.error("inside add doctor service method ----> data base already contains the doctor");
			throw new DoctorAlreadyPresentException("Present already");
		}

	}

	public String updateDoctorProfile(Doctor doctor) {
		Optional<Doctor> optionalDoctor = doctorRepository.findById(doctor.getDoctorId());
		logger.info("inside update doctor profile service method");
		if (optionalDoctor.isPresent()) {
			logger.info("inside update doctor profile service method ----> data base contains the doctor");
			doctorRepository.save(doctor);
			logger.info("inside update doctor profile service method ----> doctor is updated");
			return "The Doctor's profile is updated successfully!!";
		} else
			logger.error(
					"inside update doctor profile service method ----> databse does not contain the doctor to update");
		throw new DoctorNotFoundException("Doctor not found");
	}

	public String addAvailability(AvailabilityDate availabilityDates) {
		logger.info("inside add Availability service method");
		Optional<AvailabilityDate> date = availabilityDatesRepository
				.findByDoctorAndDate(availabilityDates.getDoctorId(), availabilityDates.getDate());
		if (!date.isPresent()) {
			logger.info("inside add Availability service method ----> availability is not present in database");
			availabilityDatesRepository.save(availabilityDates);
			logger.info("inside add Availability service method ----> So, availability is added to the data base");
			return "Availability added successfully!!";
		} else {
			logger.error("inside add Availability service method ----> availability already exists in database");
			throw new AvailabilityExistsException("present");
		}
	}

	public String updateAvailability(AvailabilityDate availabilityDates) {
		logger.info("inside update Availability service method");
		Optional<AvailabilityDate> date = availabilityDatesRepository.findById(availabilityDates.getAvailabilityId());
		if (date.isPresent()) {
			logger.info("inside update Availability service method ----> availability is present in database");
			availabilityDatesRepository.save(availabilityDates);
			logger.info("inside update Availability service method ----> availability is updated");
			return "Availability added successfully!!";
		} else {
			logger.error("inside update Availability service method ----> availability not found for updating");
			throw new AvailabilityNotFoundException("Not found");
		}

	}

	public Doctor getDoctorById(Integer doctorId) {
		logger.info("inside get doctor by id method");
		Optional<Doctor> doctor = doctorRepository.findById(doctorId);
		if (doctor.isPresent()) {
			logger.info("inside get doctor by id method ----> doctor is retrived from database");
			return doctor.get();
		} else {
			logger.error("inside get doctor by id method ----> doctor is not present in database");
			throw new IdnotFoundException("Requested Id is not found!!");
		}
	}

	public String removeDoctorById(Integer doctorId) {
		logger.info("inside remove doctor by Id service");
		Optional<Doctor> doctor = doctorRepository.findById(doctorId);
		if (doctor.isPresent()) {
			logger.info("inside remove doctor by Id service ----> doctor is present in database");
			doctorRepository.deleteById(doctorId);
			logger.info("inside remove doctor by Id service ----> doctor is deleted from database");
			return "Removed Doctor Successfully!!";
		} else {
			logger.error("inside remove doctor by Id service ----> doctor is not present in database for deletion");
			throw new IdnotFoundException("Id not found for deletion");
		}
	}

	public List<Doctor> getDoctorList() {
		logger.info("inside get doctor list service ----> all doctors are fetched from database");
		return doctorRepository.findAll();
	}

	public List<Doctor> getDoctorListBySpeciality(String speciality) {
		logger.info("inside get doctor list by speciality service");
		List<Doctor> doctors = doctorRepository.findAllByDoctorSpeciality(speciality);
		if (doctors.isEmpty()) {
			logger.error(
					"inside get doctor list by speciality ----> doctors of such speciality are not present in database");
			throw new SpecialityNotFoundException("Not found speciality");
		} else {
			logger.info(
					"inside get doctor list by speciality ----> doctors of given speciality from database are fetched");
			return doctors;
		}
	}

	public String removeAvailabilityDatesById(Integer availabilityId) {
		logger.info("inside remove availability dates by id service");
		Optional<AvailabilityDate> date = availabilityDatesRepository.findById(availabilityId);
		if (date.isPresent()) {
			logger.info("inside remove availability dates by id service ----> availability is present in database");
			availabilityDatesRepository.deleteById(availabilityId);
			logger.info("inside remove availability dates by id service ----> availability deleted from database");
			return "Availability deleted";
		} else {
			logger.error(
					"inside remove availability dates by id service ----> availability does not exist in database");
			throw new IdnotFoundException("Availability id not found");
		}

	}
	
	public List<AvailabilityDate> getAllAvailabilityDatesByDoctorId(int doctorId){
		logger.info("inside get availability dates by id service");
		Optional<Doctor> optionalDoctor =  doctorRepository.findById(doctorId);
		if (optionalDoctor.isPresent()) {
			logger.info("inside get availability dates by id service ----> Doctors is present in the database, hence availability dates are fetched");
			Doctor doctor = optionalDoctor.get();
			return doctor.getAvailabilityDates();
		}else {
			logger.info("inside get availability dates by id service ----> Doctors not found in the database");
			throw new IdnotFoundException("Doctor with this id is not found");
		}
		
	}

}
