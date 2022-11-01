package com.cg.admindata.services;

import java.util.List;

import java.util.Optional;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.admindata.entities.Admin;
import com.cg.admindata.exceptions.AdminAlreadyExistException;
import com.cg.admindata.exceptions.IdNotFoundException;
import com.cg.admindata.repositories.AdminJpaRepository;

@Service
@Transactional
public class AdminService {
	Logger logger = LoggerFactory.getLogger(AdminService.class);
	@Autowired
	private AdminJpaRepository adminRepository;

	public List<Admin> getAllAdmins() {
		logger.info("all admins from data base");
		return adminRepository.findAll();
	}

	public Admin getAdmin(int adminId) {
		logger.info("inside get admin service method");
		Optional<Admin> admin = adminRepository.findById(adminId);
		if (admin.isPresent()) {
			logger.info("inside get admin service method ----> admin by id from data base");
			return admin.get();
		} else {
			logger.info("inside get admin service method ----> data base doesn't contain admin");
			throw new IdNotFoundException("No Admin Record Found for this ID : " + adminId);
		}
	}

	public String addAdmin(Admin admin) {
		logger.info("inside add admin service method");
		Optional<Admin> retreivedAdmin = adminRepository.findByUserName(admin.getUserName());
		if (!retreivedAdmin.isPresent()) {
			logger.info("inside add admin service method ----> data base doesn't contain the admin");
			adminRepository.save(admin);
			logger.info("inside add admin service method ----> admin is added to data base");
			return "Admin Inserted Successfully";
		} else {
			logger.error("inside add admin service method ----> data base already contains the admin");
			throw new AdminAlreadyExistException("Admin Already exists");
		}
	}

	public String updateAdmin(Admin admin) {
		Optional<Admin> retreivedAdmin = adminRepository.findById(admin.getAdminId());
		if (retreivedAdmin.isPresent()) {
			logger.info("inside update admin service method ----> admin is updated to data base");
			adminRepository.save(admin);
			return "Admin Updated Successfully";
		} else
			logger.error("inside update admin service method ----> data base doesn't contain admin");
		throw new IdNotFoundException("Admin Doesn't exists");
	}

	public String removeAdmin(int adminId) {
		logger.info("inside delete admin service method");
		Optional<Admin> admin = adminRepository.findById(adminId);
		if (admin.isPresent()) {
			logger.info("inside delete admin service method ----> admin is deleted from data base");
			adminRepository.deleteById(adminId);
			return "Removed Admin Successfully";
		} else {
			logger.error("inside delete admin service method ----> data base doesn't contain admin");
			throw new IdNotFoundException("Deletion Unsuccessfull");
		}
	}
}