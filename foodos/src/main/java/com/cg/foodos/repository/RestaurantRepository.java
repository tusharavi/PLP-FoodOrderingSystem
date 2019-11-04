package com.cg.foodos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.foodos.dto.Restaurant;

/**
 * 
 */
@Repository 
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer>{

}