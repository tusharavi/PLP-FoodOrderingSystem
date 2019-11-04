package com.cg.foodos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.foodos.dto.FoodOrder;

/**
 * 
 */
@Repository 
public interface FoodOrderRepository extends JpaRepository<FoodOrder, Integer>{
//	public List<FoodOrder> findAllByAccountId(Integer accountId);
//	public List<FoodOrder> findAllByRestaurantId(Integer restaurantId);
}