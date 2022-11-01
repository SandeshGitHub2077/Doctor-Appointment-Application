package com.cg.patient.repositories;

/**
 * @author Issarapu Gangadhar	PatientJpaRepository class contains functions used in service class
 */
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.patient.entities.Patient;

@Repository
public interface PatientJpaRepository extends JpaRepository<Patient, Integer> {
	Optional<Patient> findByUserName(String userName);
}