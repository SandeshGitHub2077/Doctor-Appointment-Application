package com.example.demo.serviceTests;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.doctor.entities.AvailabilityDate;
import com.cg.doctor.entities.Doctor;
import com.cg.doctor.exceptions.AvailabilityExistsException;
import com.cg.doctor.exceptions.AvailabilityNotFoundException;
import com.cg.doctor.exceptions.DoctorAlreadyPresentException;
import com.cg.doctor.exceptions.DoctorNotFoundException;
import com.cg.doctor.exceptions.IdnotFoundException;
import com.cg.doctor.repositories.AvailabilityDatesRepository;
import com.cg.doctor.repositories.DoctorRepository;
import com.cg.doctor.services.DoctorService;

@SpringBootTest(classes = {TestDoctorService.class})
class TestDoctorService {

	@InjectMocks
	DoctorService service;

	@Mock
	private DoctorRepository doctorRepository;
	@Mock
	private AvailabilityDatesRepository availabilityDatesRepository;

	@InjectMocks
	private DoctorService doctorService;

	@Test
	void addDoctorTest() {
		Doctor doctor1 = new Doctor(1, "Ajitha", "cardiologist", "apollo", "Hyderabad", "9989899999",
				"ajitha@gmail.com", "aji9989", 400.00);
		Optional<Doctor> optionalDoctor = Optional.empty();
		when(doctorRepository.findByUserName(doctor1.getUserName())).thenReturn(optionalDoctor);
		when(doctorRepository.save(doctor1)).thenReturn(doctor1);// Mocking
		assertEquals("Doctor added successfully!", doctorService.addDoctor(doctor1));
		verify(doctorRepository, times(1)).save(doctor1);
		verify(doctorRepository, times(1)).findByUserName(doctor1.getUserName());
		
	}

	@Test
	void addDoctorFailTest() {
		Doctor doctor1 = new Doctor(1, "Ajitha", "cardiologist", "apollo", "Hyderabad", "9989899999",
				"ajitha@gmail.com", "aji9989", 400.00);
		when(doctorRepository.findByUserName(doctor1.getUserName())).thenReturn(Optional.of(doctor1));
		assertThrows(DoctorAlreadyPresentException.class, () -> doctorService.addDoctor(doctor1));
		verify(doctorRepository, times(0)).save(doctor1);
		verify(doctorRepository, times(1)).findByUserName(doctor1.getUserName());

	}

	@Test
	void updateDoctorTest() {
		Doctor doctor = new Doctor(2, "Zayn", "gynecologist", "apollo", "Banglore", "9987899997", "zayn@gmail.com",
				"zay9987", 500.00);
		when(doctorRepository.findById(2)).thenReturn(Optional.of(doctor));
		when(doctorRepository.save(doctor)).thenReturn(doctor);
		assertEquals("The Doctor's profile is updated successfully!!", doctorService.updateDoctorProfile(doctor));
		verify(doctorRepository, times(1)).save(doctor);
		verify(doctorRepository, times(1)).findById(doctor.getDoctorId());

	}

	@Test
	void updateDoctorFailTest() {
		Doctor doctor = new Doctor(2, "Zayn", "gynecologist", "apollo", "Banglore", "9987899997", "zayn@gmail.com",
				"zay9987", 500.00);
		when(doctorRepository.findById(doctor.getDoctorId())).thenReturn(Optional.empty());
		assertThrows(DoctorNotFoundException.class, () -> doctorService.updateDoctorProfile(doctor));
		verify(doctorRepository, times(0)).save(doctor);
		verify(doctorRepository, times(1)).findById(doctor.getDoctorId());
		

	}

	@Test
	void removeDoctorByIdTest() {
		Doctor doctor2 = new Doctor(2, "Zayn", "gynecologist", "apollo", "Banglore", "9987899997", "zayn@gmail.com",
				"zay9987", 500.00);
		when(doctorRepository.findById(doctor2.getDoctorId())).thenReturn(Optional.of(doctor2));
		assertEquals("Removed Doctor Successfully!!", doctorService.removeDoctorById(doctor2.getDoctorId()));
		verify(doctorRepository, times(1)).deleteById(doctor2.getDoctorId());
		verify(doctorRepository, times(1)).findById(doctor2.getDoctorId());

	}

	@Test
	void removeDoctorByIdFailTest() {
		Doctor doctor2 = new Doctor(2, "Zayn", "gynecologist", "apollo", "Banglore", "9987899997", "zayn@gmail.com",
				"zay9987", 500.00);
		when(doctorRepository.findById(doctor2.getDoctorId())).thenReturn(Optional.empty());
		assertThrows(IdnotFoundException.class, () -> doctorService.removeDoctorById(doctor2.getDoctorId()));
		verify(doctorRepository, times(1)).findById(doctor2.getDoctorId());
		verify(doctorRepository, times(0)).deleteById(doctor2.getDoctorId());
	}

	@Test
	void getDoctorByIdTest() {
		Doctor doctor2 = new Doctor(2, "Zayn", "gynecologist", "apollo", "Banglore", "9987899997", "zayn@gmail.com",
				"zay9987", 500.00);
		when(doctorRepository.findById(doctor2.getDoctorId())).thenReturn(Optional.of(doctor2));
		assertEquals(doctor2, doctorService.getDoctorById(doctor2.getDoctorId()));
		verify(doctorRepository, times(1)).findById(doctor2.getDoctorId());
	}

	@Test
	void getDoctorByIdFailTest() {
		Doctor doctor2 = new Doctor(2, "Zayn", "gynecologist", "apollo", "Banglore", "9987899997", "zayn@gmail.com",
				"zay9987", 500.00);
		when(doctorRepository.findById(doctor2.getDoctorId())).thenReturn(Optional.empty());
		assertThrows(IdnotFoundException.class, () -> doctorService.getDoctorById(doctor2.getDoctorId()));
		verify(doctorRepository, times(1)).findById(doctor2.getDoctorId());
	}

	@Test
	void getAllDoctorsTest() {
		List<Doctor> doctors = new ArrayList<>();
		doctors.add(new Doctor(2, "Zayn", "gynecologist", "apollo", "Banglore", "9987899997", "zayn@gmail.com",
				"zay9987", 500.00));
		doctors.add(new Doctor(1, "Ajitha", "cardiologist", "apollo", "Hyderabad", "9989899999", "ajitha@gmail.com",
				"aji9989", 400.00));
		when(doctorRepository.findAll()).thenReturn(doctors);
		assertEquals(doctors, doctorService.getDoctorList());
		verify(doctorRepository, times(1)).findAll();

	}

	@Test
	void getDoctorsBySpecialityTest() {
		List<Doctor> doctors = new ArrayList<>();
		doctors.add(new Doctor(2, "Zayn", "gynecologist", "apollo", "Banglore", "9987899997", "zayn@gmail.com",
				"zay9987", 500.00));
		doctors.add(new Doctor(1, "Ajitha", "gynecologist", "apollo", "Hyderabad", "9989899999", "ajitha@gmail.com",
				"aji9989", 400.00));
		when(doctorRepository.findAllByDoctorSpeciality("gynecologist")).thenReturn(doctors);
		assertEquals(doctors, doctorService.getDoctorListBySpeciality("gynecologist"));
		verify(doctorRepository, times(1)).findAllByDoctorSpeciality("gynecologist");
	}

	@Test
	void addAvailabilityTest() {
		AvailabilityDate date = new AvailabilityDate(1, 1, LocalDate.parse("2022-04-19"));
		when(availabilityDatesRepository.save(date)).thenReturn(date);
		assertEquals("Availability added successfully!!", doctorService.addAvailability(date));
		verify(availabilityDatesRepository, times(1)).save(date);

	}

	@Test
	void addAvailabilityFailTest() {
		AvailabilityDate date = new AvailabilityDate(1, 1, LocalDate.parse("2022-04-19"));
		when(availabilityDatesRepository.findByDoctorAndDate(date.getDoctorId(), date.getDate())).thenReturn(Optional.of(date));
		assertThrows(AvailabilityExistsException.class, () -> doctorService.addAvailability(date));
		verify(availabilityDatesRepository, times(0)).save(date);
		verify(availabilityDatesRepository, times(1)).findByDoctorAndDate(date.getDoctorId(), date.getDate());

	}

	@Test
	void updateAvalabilityTest() {
		AvailabilityDate date = new AvailabilityDate(1, 1, LocalDate.parse("2022-04-19"));
		when(availabilityDatesRepository.findById(date.getAvailabilityId())).thenReturn(Optional.of(date));
		when(availabilityDatesRepository.save(date)).thenReturn(date);
		assertEquals("Availability added successfully!!", doctorService.updateAvailability(date));
		verify(availabilityDatesRepository, times(1)).save(date);
		verify(availabilityDatesRepository, times(1)).findById(date.getAvailabilityId());
	}

	@Test
	void updateAvalabilityFailTest() {
		AvailabilityDate date = new AvailabilityDate(1, 1, LocalDate.parse("2022-04-19"));
		when(availabilityDatesRepository.findById(date.getAvailabilityId())).thenReturn(Optional.empty());
		assertThrows(AvailabilityNotFoundException.class, () -> doctorService.updateAvailability(date));
		verify(availabilityDatesRepository, times(0)).save(date);
		verify(availabilityDatesRepository, times(1)).findById(date.getAvailabilityId());
	}

	@Test
	void removeAvailabilityTest() {
		AvailabilityDate date = new AvailabilityDate(1, 1, LocalDate.parse("2022-04-19"));
		when(availabilityDatesRepository.findById(date.getAvailabilityId())).thenReturn(Optional.of(date));
		doctorService.removeAvailabilityDatesById(date.getAvailabilityId());
		verify(availabilityDatesRepository, times(1)).findById(date.getAvailabilityId());
		verify(availabilityDatesRepository, times(1)).deleteById(date.getAvailabilityId());
	}

	@Test
	void removeAvailabilityFailTest() {
		AvailabilityDate date = new AvailabilityDate(1, 1, LocalDate.parse("2022-04-19"));
		when(availabilityDatesRepository.findById(date.getAvailabilityId())).thenReturn(Optional.of(date));
		doctorService.removeAvailabilityDatesById(date.getAvailabilityId());
		assertThrows(IdnotFoundException.class, () -> doctorService.removeDoctorById(date.getAvailabilityId()));
		verify(availabilityDatesRepository, times(1)).deleteById(date.getAvailabilityId());
	}

}
