package com.cg.feedback.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.feedback.entites.FeedBack;
import com.cg.feedback.services.FeedBackService;

/**
 * 
 * @author Sandesh Mahajan Controller class for Feedback Module. Can perform
 *         add-feedback, get-feedback-by-id, get-all-feedback-list,
 *         get-Feedback-by-doctorId, get-Feedback-by-patientId
 *
 */
@RestController
@RequestMapping("/feedbacks")
public class FeedBackController {
	/**
	 * Logger file to log the information
	 */
	Logger logger = org.slf4j.LoggerFactory.getLogger(FeedBackController.class);
	/**
	 * Feedback controller field is used to call the service functions which perform
	 * business logic for various project functions
	 */
	@Autowired
	private FeedBackService feedBackService;

	/**
	 * 
	 * @param feedback Feedback object, contains feedback details to be added in
	 *                 database
	 * @param request  HttpServletRequest type object to get the information about
	 *                 the request headers
	 * @return ResponseInfo object as an ResponseEntity, contains HttpStatus
	 *         Information
	 */
	@PostMapping("")
	ResponseEntity<ResponseInfo> addFeedBack(@Valid @RequestBody FeedBack feedback, HttpServletRequest request) {
		logger.info("Adding Feedback in DataBase.");
		String message = feedBackService.addFeedBack(feedback);
		ResponseInfo responseInfo = new ResponseInfo(HttpStatus.CREATED.value(), HttpStatus.CREATED.name(), message,
				request.getRequestURI());
		logger.info("Execution of addFeedback completed.");
		return new ResponseEntity<>(responseInfo, HttpStatus.CREATED);
	}

	/**
	 * 
	 * @return List of feedback objects present in database
	 */
	@GetMapping("")
	List<FeedBack> getAllFeedbacks() {
		logger.info("Get all entries in Feedback DataBase.");
		return feedBackService.getAllFeedbacks();
	}

	/**
	 * 
	 * @param feedBackId used for searching feedback entry in database
	 * @return feedback object that is found using parameter in database
	 */
	@GetMapping("/{feedback_id}")
	public FeedBack getFeedBackById(@PathVariable("feedback_id") int feedBackId) {
		logger.info("Getting Feedback by FeedbackId from Feedback DataBase.");
		return feedBackService.getFeedBackById(feedBackId);
	}

	/**
	 * 
	 * @param patientId used for searching feedback entry in database
	 * @return feedback object that is found using parameter in database
	 */
	@GetMapping("/patientId/{patientId}")
	List<FeedBack> findAllByPatientId(@PathVariable("patientId") int patientId) {
		logger.info("Getting Feedback by PatientId from Feedback DataBase.");
		return feedBackService.findAllByPatientId(patientId);
	}

	/**
	 * 
	 * @param doctorId used for searching feedback entry in database
	 * @return feedback object that is found using parameter in database
	 */
	@GetMapping("/doctorId/{doctorId}")
	List<FeedBack> findAllByDoctorId(@PathVariable("doctorId") int doctorId) {
		logger.info("Getting Feedback by DoctorId from Feedback DataBase.");
		return feedBackService.findAllByDoctorId(doctorId);
	}

}
