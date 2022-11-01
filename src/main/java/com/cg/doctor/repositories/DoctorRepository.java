package com.cg.doctor.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.doctor.entities.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer>{
	public List<Doctor> findAllByDoctorSpeciality(String speciality);

	public Optional<Doctor> findByUserName(String userName);

}
