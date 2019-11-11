package com.cg.foodos.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.foodos.dto.Food;
import com.cg.foodos.repository.FoodRepository;

@Service("foodService")
@Transactional
public class FoodServiceImpl implements FoodService {
	
	@Autowired
	FoodRepository foodRepository;
	
	public List<Food> findAll() {
		
		return foodRepository.findAll();
	}

	/**
	 * @param food
	 */
	public void delete(Food food) {
		foodRepository.delete(food);
	}

	/**
	 * @param foodId
	 * @return
	 */
	public Optional<Food> findById(Integer foodId) {
		
		return foodRepository.findById(foodId);
	}

	/**
	 * @param food
	 * @return
	 */
	public Food save(Food food) {
		foodRepository.save(food);
		return food;
	}

	@Override
	public void deleteById(Integer foodId) {
		foodRepository.deleteById(foodId);
		return;
	}

}
