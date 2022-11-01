package com.cg.appointment.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.appointment.entities.Appointment;
import com.cg.appointment.entities.AppointmentStatus;
import com.cg.appointment.exceptions.IdNotFoundException;
import com.cg.appointment.repositories.AppointmentJpaRepository;

/**
 * 
 * @author B.Rishita
 *
 */
@SpringBootTest(classes = AppointmentServiceTest.class)
public class AppointmentServiceTest {
	/**
	 *  
	 */
	@Mock
	AppointmentJpaRepository appointmentRepository;

	@InjectMocks
	AppointmentService appointmentService;

	@Test
	void addAppointmentTest() {
		Appointment appointment = new Appointment(1, 101, 201, LocalDate.now(), AppointmentStatus.ACCEPTED, "Good");
		when(appointmentRepository.save(appointment)).thenReturn(appointment);
		assertEquals("Appointmet Inserted Successfully", appointmentService.addAppointment(appointment));
		verify(appointmentRepository, times(1)).save(appointment);

	}

	@Test
	void addAppointmentFailTest() {
		Appointment appointment = new Appointment(1, 101, 201, LocalDate.now(), AppointmentStatus.ACCEPTED, "Good");
		when(appointmentRepository.save(appointment)).thenReturn(appointment);
		assertNotEquals("Appointmet Inserted Successfully", appointmentService.addAppointment(appointment));
		verify(appointmentRepository, times(1)).save(appointment);

	}

	@Test
	void getAllAppointmentsTest() {
		List<Appointment> appointmentsList = new ArrayList<Appointment>();
		appointmentsList.add(new Appointment(1, 101, 201, LocalDate.now(), AppointmentStatus.ACCEPTED, "Good"));
		when(appointmentRepository.findAll()).thenReturn(appointmentsList);
		assertEquals(appointmentsList, appointmentService.getAllAppointments());
	}

	@Test
	void getAllAppointmentsFailTest() {
		List<Appointment> appointmentsList = new ArrayList<Appointment>();
		appointmentsList.add(new Appointment(1, 101, 201, LocalDate.now(), AppointmentStatus.ACCEPTED, "Good"));
		when(appointmentRepository.findAll()).thenReturn(appointmentsList);
		assertNotEquals(appointmentsList, appointmentService.getAllAppointments());
	}

	@Test
	void getAppointmentByIdTest() {
		Appointment appointment = new Appointment(1, 101, 201, LocalDate.now(), AppointmentStatus.ACCEPTED, "Good");
		when(appointmentRepository.findById(appointment.getAppointmentId())).thenReturn(Optional.of(appointment));
		when(appointmentRepository.save(appointment)).thenReturn(appointment);
		assertEquals(appointment, appointmentService.getAppointmentById(appointment.getAppointmentId()));
	}

	@Test
	void getAppointmentByIdFailTest() {
		Appointment appointment = new Appointment(1, 101, 201, LocalDate.now(), AppointmentStatus.ACCEPTED, "Good");
		when(appointmentRepository.findById(appointment.getAppointmentId())).thenReturn(Optional.of(appointment));
		when(appointmentRepository.save(appointment)).thenReturn(appointment);
		assertThrows(IdNotFoundException.class,
				() -> appointmentService.getAppointmentById(appointment.getAppointmentId()));

	}

	@Test
	void deleteAppointmentByIdTest() {
		Appointment appointment = new Appointment(1, 101, 201, LocalDate.now(), AppointmentStatus.ACCEPTED, "Good");
		when(appointmentRepository.findById(appointment.getAppointmentId())).thenReturn(Optional.of(appointment));
		assertEquals("Appointment Successfully deleted",
				appointmentService.deleteAppointmentById(appointment.getAppointmentId()));
		verify(appointmentRepository, times(1)).deleteById(appointment.getAppointmentId());

	}

	@Test
	void deleteAppointmentByIdTestFail() {
		Appointment appointment = new Appointment(1, 101, 201, LocalDate.now(), AppointmentStatus.ACCEPTED, "Good");
		when(appointmentRepository.findById(appointment.getAppointmentId())).thenReturn(Optional.empty());
		assertThrows(IdNotFoundException.class,
				() -> appointmentService.deleteAppointmentById(appointment.getAppointmentId()));
		verify(appointmentRepository, times(0)).deleteById(appointment.getAppointmentId());

	}

	@Test
	void getAppointmentListByDoctorIdTest() {
		List<Appointment> appointmentsList = new ArrayList<Appointment>();
		int DId = 5;
		appointmentsList.add(new Appointment(1, 101, 201, LocalDate.now(), AppointmentStatus.ACCEPTED, "Good"));
		when(appointmentRepository.findAllByDoctorId(DId)).thenReturn(appointmentsList);
		assertEquals(appointmentsList, appointmentService.getAppointmentListByDoctorId(DId));

	}

	@Test
	void getAppointmentListByDoctorIdTestFail() {
		List<Appointment> appointmentsList = new ArrayList<Appointment>();
		appointmentsList.add(new Appointment(1, 101, 201, LocalDate.now(), AppointmentStatus.ACCEPTED, "Good"));
		int DId = 5;
		when(appointmentRepository.findAllByDoctorId(DId)).thenReturn(appointmentsList);
		assertEquals(appointmentsList, appointmentService.getAppointmentListByDoctorId(DId));

	}

	@Test
	void getAppointmentListByPatientIdTest() {
		List<Appointment> appointmentsList = new ArrayList<Appointment>();
		appointmentsList.add(new Appointment(1, 101, 201, LocalDate.now(), AppointmentStatus.ACCEPTED, "Good"));
		int PId = 3;
		when(appointmentRepository.findAllByPatientId(PId)).thenReturn(appointmentsList);
		assertEquals(appointmentsList, appointmentService.getAppointmentListByPatientId(PId));

	}

	@Test
	void getAppointmentListByPatientIdTestFail() {
		List<Appointment> appointmentsList = new ArrayList<Appointment>();
		appointmentsList.add(new Appointment(1, 101, 201, LocalDate.now(), AppointmentStatus.ACCEPTED, "Good"));
		int PId = 3;
		when(appointmentRepository.findAllByPatientId(PId)).thenReturn(appointmentsList);
		assertEquals(appointmentsList, appointmentService.getAppointmentListByPatientId(PId));

	}

}
