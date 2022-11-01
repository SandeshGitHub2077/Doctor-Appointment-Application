package com.cg.admindata.services;


import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.admindata.entities.Admin;
import com.cg.admindata.exceptions.IdNotFoundException;
import com.cg.admindata.exceptions.AdminAlreadyExistException;
import com.cg.admindata.repositories.AdminJpaRepository;


@SpringBootTest
class AdminServiceTest {

	@Mock
	private AdminJpaRepository adminRepository;
	@InjectMocks
	private AdminService adminService;

	@Test
	void getAllAdminsTest() {
		List<Admin> admin = new ArrayList<>();
		admin.add(new Admin("Admin", 1, "Ankith", "9905678956", "ankithThrivedi@gmail.com", "Ankith23"));
		admin.add(new Admin("Admin", 4, "smith", "9903498773", "smithjohn@gmail.com", "smith@7"));
		when(adminRepository.findAll()).thenReturn(admin);
		assertEquals(admin, adminService.getAllAdmins());
		verify(adminRepository,times(1)).findAll();
	}

	@Test
	void getAdminTest() {
		Admin admin = new Admin("Ankith", 1, "Ankith", "9905678956", "ankithThrivedi@gmail.com", "Ankith23");
		when(adminRepository.findById(admin.getAdminId())).thenReturn(Optional.of(admin));
		when(adminRepository.save(admin)).thenReturn(admin);
		assertEquals(admin, adminService.getAdmin(admin.getAdminId()));
		verify(adminRepository,times(1)).findById(admin.getAdminId());
	}

	@Test
	void getAdminFailTest() {
		Admin admin = new Admin("Ankith", 1, "Ankith", "9905678956", "ankithThrivedi@gmail.com", "Ankith23");
		when(adminRepository.findById(admin.getAdminId())).thenReturn(Optional.empty());
		when(adminRepository.save(admin)).thenReturn(admin);
		assertThrows(IdNotFoundException.class,()-> adminService.getAdmin(admin.getAdminId()));
		verify(adminRepository,times(1)).findById(admin.getAdminId());
	}

	@Test
	void addAdminTest() {
		Admin admin = new Admin("Smith_3", 4, "smith", "9903498773", "smithjohn@gmail.com", "smith@7");
		when(adminRepository.findByUserName(admin.getUserName())).thenReturn(Optional.empty());
		when(adminRepository.save(admin)).thenReturn(admin);
		assertEquals("Admin Inserted Successfully", adminService.addAdmin(admin));
		verify(adminRepository,times(1)).findByUserName(admin.getUserName());
		verify(adminRepository,times(1)).save(admin);
	}

	@Test
	void addAdminFailTest() {
		Admin admin = new Admin("Smith_3", 4, "smith", "9903498773", "smithjohn@gmail.com", "smith@7");
		when(adminRepository.findByUserName(admin.getUserName())).thenReturn(Optional.of(admin));
		when(adminRepository.save(admin)).thenReturn(admin);
		assertThrows(AdminAlreadyExistException.class,()-> adminService.addAdmin(admin));
		verify(adminRepository,times(1)).findByUserName(admin.getUserName());
		verify(adminRepository,times(0)).save(admin);
	}

	@Test
	void updateAdminTest() {
		Admin admin = new Admin("Anitha", 4, "Anitha", "660549877", "ankitha@gmail.com", "smith@7");
		when(adminRepository.findById(admin.getAdminId())).thenReturn(Optional.of(admin));
		when(adminRepository.save(admin)).thenReturn(admin);
		assertEquals("Admin Updated Successfully", adminService.updateAdmin(admin));
		verify(adminRepository,times(1)).findById(admin.getAdminId());
		verify(adminRepository,times(1)).save(admin);
	}

	@Test
	void updateAdminFailTest() {
		Admin admin = new Admin("Anitha", 4, "Anitha", "660549877", "ankitha@gmail.com", "smith@7");
		when(adminRepository.findById(admin.getAdminId())).thenReturn(Optional.empty());
		when(adminRepository.save(admin)).thenReturn(admin);
		assertThrows(IdNotFoundException.class,()-> adminService.updateAdmin(admin));
		verify(adminRepository,times(1)).findById(admin.getAdminId());
		verify(adminRepository,times(0)).save(admin);
	}

	@Test
	void removeAdminTest() {
		Admin admin = new Admin("Admin", 1, "smith", "990349877", "smithjohn@gmail.com", "smith@7");
		when(adminRepository.findById(admin.getAdminId())).thenReturn(Optional.of(admin));
		when(adminRepository.save(admin)).thenReturn(admin);
		assertEquals("Removed Admin Successfully", adminService.removeAdmin(admin.getAdminId()));
		verify(adminRepository,times(1)).findById(admin.getAdminId());
		verify(adminRepository,times(1)).deleteById(admin.getAdminId());
	}

	@Test
	void removeAdminFailTest() {
		Admin admin = new Admin("Smith_3", 1, "smith", "990349877", "smithjohn@gmail.com", "smith@7");
		when(adminRepository.findById(admin.getAdminId())).thenReturn(Optional.empty());
		when(adminRepository.save(admin)).thenReturn(admin);
		assertThrows(IdNotFoundException.class,()-> adminService.removeAdmin(admin.getAdminId()));
		verify(adminRepository,times(1)).findById(admin.getAdminId());
		verify(adminRepository,times(0)).deleteById(admin.getAdminId());
	}

}
