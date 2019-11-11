package com.cg.foodos.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.foodos.dto.Restaurant;
import com.cg.foodos.repository.RestaurantRepository;

@Service("restaurantService")
@Transactional
public class RestaurantServiceImpl implements RestaurantService {
	
	@Autowired
	RestaurantRepository restaurantRepository;
	
	
	/**
     * @param restaurant 
     * @return
     */
    public Restaurant save(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
        return restaurantRepository.getOne(restaurant.getRestaurantId());
    }

    /**
     * @return
     */
    public List<Restaurant> findAll() {
        
        return restaurantRepository.findAll();
    }

    /**
     * @param restaurant
     */
    public void delete(Restaurant restaurant) {
    	restaurantRepository.delete(restaurant);
    }

    /**
     * @param restaurantId 
     * @return
     */
    public Optional<Restaurant> findById(Integer restaurantId) {
        
        return restaurantRepository.findById(restaurantId);
    }

	@Override
	public void deleteById(Integer restaurantId) {
		restaurantRepository.deleteById(restaurantId);
	}

}
