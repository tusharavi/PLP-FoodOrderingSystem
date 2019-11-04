package com.cg.foodos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.foodos.dto.User;

/**
 * 
 */
@Repository 
public interface UserRepository extends JpaRepository<User, Integer>{

}