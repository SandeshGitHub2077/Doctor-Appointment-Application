package com.cg.feedback.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.cg.feedback.entites.FeedBack;
import com.cg.feedback.exceptions.IdNotFoundException;
import com.cg.feedback.repositories.FeedBackJpaRepository;

/**
 * 
 * @author Sandesh Mahajan Feedback service class performs services for
 *         controller class functions
 *
 */
@Service
public class FeedBackService {

	/**
	 * Logger file to log the information
	 */
	Logger logger = org.slf4j.LoggerFactory.getLogger(FeedBackService.class);
	/**
	 * Feedback service field is used to perform business logic for adding,
	 * add-feedback, get-feedback-by-id, get-all-feedback-list,
	 * get-Feedback-by-doctorId, get-Feedback-by-patientId
	 */
	@Autowired
	public FeedBackJpaRepository feedBackJpaRepository;

	/**
	 * 
	 * @param feedback feedback Feedback object, contains feedback details to be
	 *                 added in database
	 * @return String of added or rejected entry
	 */
	public String addFeedBack(FeedBack feedback) {
		feedBackJpaRepository.save(feedback);

		logger.info("Feedback added successfully");
		return "Added successfully";
	}

	/**
	 * 
	 * @return List of feedback objects
	 */
	public List<FeedBack> getAllFeedbacks() {
		logger.info("Getting all the feedbacks from Feedback DB");
		return feedBackJpaRepository.findAll();
	}

	/**
	 * 
	 * @param feedBackId used for searching feedback entry in database
	 * @return feedback object containing feedback data with respect to feedbackId
	 */
	public FeedBack getFeedBackById(int feedBackId) {
		logger.info("Getting all the feedbacks using feedbackId from Feedback DB");
		Optional<FeedBack> feedBack = feedBackJpaRepository.findById(feedBackId);
		// Exception for no feedbackId
		if (!feedBack.isPresent())
			throw new IdNotFoundException("No such FeedbackId present");
		// getting of feedback function starts here
		return feedBack.get();
	}

	/**
	 * 
	 * @param patientId used for searching patient entry in database
	 * @return List of all feedback objects with respect to the patientId
	 */
	public List<FeedBack> findAllByPatientId(@PathVariable("patientId") int patientId) {
		logger.info("Getting all the feedbacks entered by 1 Patient from Feedback DB");
		List<FeedBack> feedBack = feedBackJpaRepository.findAllByPatientId(patientId);
		// Exception for no PatientId
		if (feedBack.isEmpty())
			throw new IdNotFoundException("No such PatientId present");
		// getting of patient feedback function starts here
		return feedBack;
	}

	/**
	 * 
	 * @param doctorId used for searching doctor entry in database
	 * @return List of all feedback objects with respect to the doctorId
	 */
	public List<FeedBack> findAllByDoctorId(@PathVariable("doctorId") int doctorId) {
		logger.info("Getting all the feedbacks received by 1 Doctor from Feedback DB");
		List<FeedBack> feedBack = feedBackJpaRepository.findAllByDoctorId(doctorId);
		// Exception for no DoctorId
		if (feedBack.isEmpty())
			throw new IdNotFoundException("No such doctorId present");
		// getting of doctor feedback function starts here
		return feedBack;
	}

}
