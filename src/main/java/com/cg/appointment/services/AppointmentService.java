package com.cg.appointment.services;

import java.time.LocalDate;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.appointment.entities.Appointment;
import com.cg.appointment.entities.AppointmentStatus;
import com.cg.appointment.exceptions.AppointmentNotFoundException;
import com.cg.appointment.exceptions.AppointmentNotRegisteredException;
import com.cg.appointment.exceptions.AppointmentStatusNotFoundException;
import com.cg.appointment.exceptions.DoctorNotFoundException;
import com.cg.appointment.exceptions.IdNotFoundException;
import com.cg.appointment.exceptions.PatientNotFoundException;
import com.cg.appointment.repositories.AppointmentJpaRepository;

/**
 * 
 * @author B.Rishita
 *
 */
@Service
@Transactional
public class AppointmentService {

	/**
	 * Logger file to log the information
	 */
	Logger logger = LoggerFactory.getLogger(AppointmentService.class);

	/**
	 * Appointment Repository field is used to perform business logic for adding
	 * appointment, deleting appointment, getting all appointments, updating status
	 */
	@Autowired
	private AppointmentJpaRepository appointmentRepository;

	/**
	 * 
	 * @return List of all appointments
	 */
	public List<Appointment> getAllAppointments() {

		logger.info("All Appointments from Database");
		return appointmentRepository.findAll();
	}

	/**
	 * 
	 * @param id Id Entity is used to get the appointment details with that id
	 * @return Appointment type object with details of appointment with given Id
	 *         else throws IDNotFoundException
	 */
	public Appointment getAppointmentById(int id) {

		logger.info("inside get Appointments By Id Service Method");
		Optional<Appointment> appointment = appointmentRepository.findById(id);
		if (appointment.isPresent()) {
			logger.info("inside get Appointments By Id Service Method -----> Appointment is displayed");
			return appointment.get();
		} else
			logger.info("inside get Appointments By Id Service Method -----> Database has no record for this ID");
		throw new IdNotFoundException("No Record found for this Id: " + id);

	}

	/**
	 * 
	 * @param appointment Appointment object will be added
	 * @return Message if appoiyment is added else throws AppointmentNotRegistered
	 *         Exception
	 */
	public String addAppointment(Appointment appointment) {

		logger.info("Inside Add appointment service method");
		appointmentRepository.save(appointment);
		logger.info("Inside Add Appointment service method ----->  Appointment is added into the database");
		return "Appointment Registered Successfully";

	}

	/**
	 * 
	 * @param id     Id Entity is used to get the appointment status with that id
	 * @param status Status details are fetched to change the status
	 * @return IF status is changed or throws IDNotFoundException
	 */

	public String changeStatus(int id, AppointmentStatus status) {

		logger.info("Inside changeStatus service method");
		Optional<Appointment> statusUpdate = appointmentRepository.findById(id);
		if (statusUpdate.isPresent()) {
			Appointment appointment = statusUpdate.get();
			appointment.setAppointmentStatus(status);
			appointmentRepository.save(appointment);
			return "Status Updated Successfully";

		} else
			throw new IdNotFoundException("Requested ID is not found");

	}

	/**
	 * 
	 * @param id Id Entity is used to get the appointment details with that id
	 * @return If appointment is deleted successfully else throws
	 *         IDNotFoundException
	 */
	public String deleteAppointmentById(int id) {

		logger.info("Inside delete appointment service method");
		Optional<Appointment> appointment = appointmentRepository.findById(id);
		if (appointment.isPresent()) {
			appointmentRepository.deleteById(id);
			return "Deleted Successfully!!!";
		} else
			throw new IdNotFoundException("No Record found for this Id: " + id);
	}

	/**
	 * 
	 * @param DId Doctor Id is used to get the list of all appointments of the
	 *            doctor Id
	 * @return List of appointments with the doctor Id else throws
	 *         DoctorNotFoundException
	 */
	public List<Appointment> getAppointmentListByDoctorId(int DId) {

		logger.info("inside get Appointment By Doctor Id method");
		List<Appointment> doctorlist = appointmentRepository.findAllByDoctorId(DId);
		if (!doctorlist.isEmpty())
			return doctorlist;
		else
			throw new DoctorNotFoundException("No Record found for this Doctor Id :" + DId);

	}

	/**
	 * 
	 * @param PId Patient Id is used to get the list of all appointments of the
	 *            Patient Id
	 * @return List of appointments with the Patient Id else throws
	 *         PatientNotFoundException
	 */
	public List<Appointment> getAppointmentListByPatientId(int PId) {

		logger.info("inside get Appointment By Patient Id method");
		List<Appointment> patientlist = appointmentRepository.findAllByPatientId(PId);
		if (!patientlist.isEmpty())
			return patientlist;
		else
			throw new PatientNotFoundException("No Record found for this Doctor Id :" + PId);

	}

	/**
	 * 
	 * @param date Date Entity is used to get the appointments with the date
	 * @return List os appointments else throws AppointmentNotFoundException
	 */
	public List<Appointment> getAppointmentListByDate(LocalDate date) {

		logger.info("inside get Appointment List By Date method");
		List<Appointment> appointmentList = appointmentRepository.findAllByAppointmentDate(date);
		if (!appointmentList.isEmpty())
			return appointmentList;
		else
			throw new AppointmentNotFoundException("No Appointment is found");
	}

	/**
	 * 
	 * @param id Id Entity is used to get the appointment details with that id
	 * @return Status of appointment else throws AppointmentStatusNotFoundException
	 */
	public AppointmentStatus getAppointmentStatusById(int id) {

		logger.info("inside get Appointment Status By Id method");
		Optional<Appointment> appointment = appointmentRepository.findById(id);
		if (appointment.isPresent())
			return appointment.get().getAppointmentStatus();
		else
			throw new AppointmentStatusNotFoundException("No Status is found for this Appointment Id :" + id);
	}

	public String updateAppointment(Appointment appointment) {
		logger.info("inside udate appointment method");
		Optional<Appointment> retreivedAppointment = appointmentRepository.findById(appointment.getAppointmentId());
		if (retreivedAppointment.isPresent()) {
			System.out.println(appointment);
			appointmentRepository.save(appointment);
			logger.info("appointment updated successfully");
		} else {
			throw new AppointmentNotFoundException(
					"Appointment is not found with id :" + appointment.getAppointmentId());
		}
		return "Appointment updated successfully";
	}

}