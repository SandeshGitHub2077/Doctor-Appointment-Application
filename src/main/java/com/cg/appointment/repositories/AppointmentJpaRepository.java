package com.cg.appointment.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.appointment.entities.Appointment;

/**
 * 
 * @author B.Rishita
 *
 */
@Repository
public interface AppointmentJpaRepository extends JpaRepository<Appointment, Integer> {

	/**
	 * 
	 * @param doctorId doctor Id parameter is passed
	 * @return List of appointments with the doctor ID
	 */
	List<Appointment> findAllByDoctorId(int doctorId);

	/**
	 * 
	 * @param patientId patient Id parameter is passed
	 * @return List of appointments with the patient ID
	 */

	List<Appointment> findAllByPatientId(int patientId);

	/**
	 * 
	 * @param appointmentDate LocalDate appointment Date parameter is passed
	 * @return List of appointments with the appointment Date
	 */
	List<Appointment> findAllByAppointmentDate(LocalDate appointmentDate);

}
