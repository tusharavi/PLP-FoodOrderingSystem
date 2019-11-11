package com.cg.foodos.service;

import java.util.List;
import java.util.Optional;
import com.cg.foodos.dto.Food;

public interface FoodService {
	public List<Food> findAll();
	public void delete(Food food);
	public Optional<Food> findById(Integer foodId);
	public Food save(Food food);
	public void deleteById(Integer foodId);
}
