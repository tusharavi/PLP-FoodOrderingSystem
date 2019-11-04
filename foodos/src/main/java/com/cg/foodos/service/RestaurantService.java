package com.cg.foodos.service;

import java.util.List;
import com.cg.foodos.dto.Restaurant;

public interface RestaurantService {
	public Restaurant save(Restaurant restaurant);
	public List<Restaurant> findAll() ;
	public void delete(Restaurant restaurant);
	public Restaurant findById(Integer restaurantId);
	public void deleteById(Integer restaurantId);
}
