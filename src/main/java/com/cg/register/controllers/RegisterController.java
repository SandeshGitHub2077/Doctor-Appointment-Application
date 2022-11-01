package com.cg.register.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.register.dto.Admin;
import com.cg.register.dto.Doctor;
import com.cg.register.dto.Patient;
import com.cg.register.dto.User;

import static com.cg.register.constants.ConstantStrings.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/register")
public class RegisterController {
	@Autowired
	RestTemplate restTemplate;

	@Autowired
	PasswordEncoder bCryptPasswordEncoder;

	@PostMapping("/patient")
	public ResponseEntity<ResponseInfo> registerPatient(@RequestBody Patient patient,
			HttpServletRequest httpServletRequest) {
		restTemplate.postForEntity(ADDPATIENT, patient, ResponseInfo.class);
		User user = new User(patient.getUserName(),bCryptPasswordEncoder.encode(patient.getPassword()),"ROLE_PATIENT");
		return restTemplate.postForEntity(ADDUSER,user ,ResponseInfo.class);
		
	}

	@PostMapping("/admin")
	public ResponseEntity<ResponseInfo> registerAdmin(@RequestBody Admin admin, HttpServletRequest httpServletRequest) {
		restTemplate.postForEntity(ADDADMIN, admin, ResponseInfo.class);
		User user = new User(admin.getUserName(),bCryptPasswordEncoder.encode(admin.getPassword()),"ROLE_ADMIN");
		return restTemplate.postForEntity(ADDUSER,user ,ResponseInfo.class);
	}

	@PostMapping("/doctor")
	public ResponseEntity<ResponseInfo> registerDoctor(@RequestBody Doctor doctor,
			HttpServletRequest httpServletRequest) {
		restTemplate.postForEntity(ADDDOCTOR, doctor, ResponseInfo.class);
		User user = new User(doctor.getUserName(),bCryptPasswordEncoder.encode(doctor.getPassword()),"ROLE_DOCTOR");
		return restTemplate.postForEntity(ADDUSER,user ,ResponseInfo.class);
	}
}
