package com.cg.feedback.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.feedback.entites.FeedBack;

/**
 * 
 * @author Sandesh Mahajan Repository class contains the custom functions which
 *         are used by service class
 *
 */
@Repository
public interface FeedBackJpaRepository extends JpaRepository<FeedBack, Integer> {
	/**
	 * 
	 * @param patientId used for searching Patient entry in database
	 * @return List of all Patients objects in database
	 */
	public List<FeedBack> findAllByPatientId(int patientId);

	/**
	 * 
	 * @param doctorId used for searching Doctor entry in database
	 * @return List of all Doctors objects in database
	 */
	public List<FeedBack> findAllByDoctorId(int doctorId);
}
