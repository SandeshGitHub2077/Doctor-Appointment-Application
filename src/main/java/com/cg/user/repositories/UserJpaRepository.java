package com.cg.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.user.entities.User;

/**
 * 
 * @author Kambala Nitheesh Kumar
 *
 */
@Repository
public interface UserJpaRepository extends JpaRepository<User, String> {
	
}
