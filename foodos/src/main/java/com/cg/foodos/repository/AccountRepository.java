package com.cg.foodos.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.foodos.dto.Account;

/**
 * 
 */
@Repository 
public interface AccountRepository extends JpaRepository<Account, Integer>{

    
}