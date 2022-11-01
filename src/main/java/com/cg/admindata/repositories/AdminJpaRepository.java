package com.cg.admindata.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.admindata.entities.Admin;

@Repository
public interface AdminJpaRepository extends JpaRepository<Admin, Integer> {
	Optional<Admin> findByUserName(String userName);
}
