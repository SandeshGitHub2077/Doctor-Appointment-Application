package com.cg.admindata.controllers;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.admindata.entities.Admin;
import com.cg.admindata.services.AdminService;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * 
 * @author Amburi Alekhya 
 * Controller class for Admin, can perform get admins, get admin by id,
 *  add admin, update admin, delete admin
 *
 */
@RestController
@RequestMapping("/admins")
public class AdminController {
	/**
	 * Logger is importing from the logger family for admin controller class
	 */
	Logger logger = LoggerFactory.getLogger(AdminController.class);
	/**
	 * Admin Service field is used to perform business logic for getting admins,
	 * getting admin by id, adding admin, updating admins, deleting admins
	 */
	@Autowired
	private AdminService adminService;

	/**
	 * 
	 * @param request HttpServletRequest Type object to get the information about
	 *                the request headers
	 * @return List of admin objects
	 */
	@GetMapping()
	public List<Admin> getAllAdmins(HttpServletRequest request) {
		logger.info("get all admins from database");
		return adminService.getAllAdmins();
	}

	/**
	 * 
	 * @param adminId By the adminId variable getting the admin object
	 * @param request HttpServletRequest Type object to get the information about
	 *                the request headers
	 * @return Based on adminId getting the admin object
	 */
	@GetMapping("/{id}")
	public Admin getAdmin(@PathVariable(value = "id") int adminId, HttpServletRequest request) {
		logger.info("get admin by Id from database");
		return adminService.getAdmin(adminId);
	}

	/**
	 * 
	 * @param admin   Admin object that will be added
	 * @param request HttpServletRequest Type object to get the information about
	 *                the request headers
	 * @return ResponseInfo object as an ResponseEntity, contains HttpStatus
	 *         Information
	 */
	@PostMapping()
	public ResponseEntity<ResponseInfo> addAdmin(@Valid @RequestBody Admin admin, HttpServletRequest request) {
		logger.info("create admin Id from database");
		String msg = adminService.addAdmin(admin);
		logger.info("In add admin Method");
		ResponseInfo info = new ResponseInfo(HttpStatus.CREATED.value(), HttpStatus.CREATED.name(), msg,
				request.getRequestURI());
		return new ResponseEntity<>(info, HttpStatus.CREATED);
	}

	/**
	 * 
	 * @param admin   Admin object that will be updated
	 * @param request HttpServletRequest Type object to get the information about
	 *                the request headers
	 * @return ResponseInfo object as an ResponseEntity, contains HttpStatus
	 *         Information
	 */
	@PutMapping()
	public ResponseEntity<ResponseInfo> updateAdmin(@Valid @RequestBody Admin admin, HttpServletRequest request) {
		logger.info("update admin by Id from database");
		String msg = adminService.updateAdmin(admin);
		ResponseInfo info = new ResponseInfo(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED.name(), msg,
				request.getRequestURI());
		return new ResponseEntity<>(info, HttpStatus.ACCEPTED);
	}

	/**
	 * 
	 * @param adminId AdminId for deleting the admin object
	 * @param request HttpServletRequest Type object to get the information about
	 *                the request headers
	 * @return ResponseInfo object as an ResponseEntity, contains HttpStatus
	 *         Information
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseInfo> removeAdmin(@PathVariable(value = "id") int adminId,
			HttpServletRequest request) {
		logger.info("delete admin by Id from database");
		String msg = adminService.removeAdmin(adminId);
		ResponseInfo info = new ResponseInfo(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED.name(), msg,
				request.getRequestURI());
		return new ResponseEntity<>(info, HttpStatus.ACCEPTED);
	}
}
