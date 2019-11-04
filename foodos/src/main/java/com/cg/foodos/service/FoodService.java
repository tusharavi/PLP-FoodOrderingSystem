package com.cg.foodos.service;

import java.util.List;
import java.util.Set;

import com.cg.foodos.dto.Food;

public interface FoodService {
	public List<Food> findAll();
	public void delete(Food food);
	public Food findById(Integer foodId);
	public Set<Food> findAllByRestaurantId(Integer restaurantId);
	public Food save(Food food);
	public void deleteById(Integer foodId);
}
