package com.cg.foodos.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.foodos.dto.Food;
import com.cg.foodos.repository.FoodRepository;

@Service("foodService")
public class FoodServiceImpl implements FoodService {
	
	@Autowired
	FoodRepository foodRepository;
	
	public List<Food> findAll() {
		
		return null;
	}

	/**
	 * @param food
	 */
	public void delete(Food food) {
		
	}

	/**
	 * @param foodId
	 * @return
	 */
	public Food findById(Integer foodId) {
		
		return null;
	}

	/**
	 * @param restaurantId
	 * @return
	 */
	public Set<Food> findAllByRestaurantId(Integer restaurantId) {
		
		return null;
	}

	/**
	 * @param food
	 * @return
	 */
	public Food save(Food food) {
		
		return null;
	}

	@Override
	public void deleteById(Integer foodId) {
		foodRepository.deleteById(foodId);
		return;
	}

}
