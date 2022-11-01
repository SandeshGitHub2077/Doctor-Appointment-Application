package com.cg.login.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.login.entities.User;
/**
 * 
 * @author Kambala Nitheesh Kumar
 *
 */
@Repository
public interface UserJpaRepository extends JpaRepository<User, String> {

}
