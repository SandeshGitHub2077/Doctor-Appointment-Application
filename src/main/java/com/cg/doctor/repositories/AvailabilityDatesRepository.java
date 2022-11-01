package com.cg.doctor.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.doctor.entities.AvailabilityDate;

@Repository
public interface AvailabilityDatesRepository extends JpaRepository<AvailabilityDate, Integer>{
	
	@Query("select a from AvailabilityDate a where a.doctorId = ?1 and a.date = ?2")
	public Optional<AvailabilityDate> findByDoctorAndDate(int doctorId, LocalDate date);

}
