package com.cg.foodos.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.foodos.dto.Restaurant;
import com.cg.foodos.repository.RestaurantRepository;

@Service("restaurantService")
public class RestaurantServiceImpl implements RestaurantService {
	
	@Autowired
	RestaurantRepository restaurantRepository;
	
	
	/**
     * @param restaurant 
     * @return
     */
    public Restaurant save(Restaurant restaurant) {
        
        return null;
    }

    /**
     * @return
     */
    public List<Restaurant> findAll() {
        
        return null;
    }

    /**
     * @param restaurant
     */
    public void delete(Restaurant restaurant) {
        
    }

    /**
     * @param restaurantId 
     * @return
     */
    public Restaurant findById(Integer restaurantId) {
        
        return null;
    }

	@Override
	public void deleteById(Integer restaurantId) {
		restaurantRepository.deleteById(restaurantId);
	}

}
