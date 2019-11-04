package com.cg.foodos.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.foodos.dto.Account;
import com.cg.foodos.dto.Food;
import com.cg.foodos.dto.Restaurant;
import com.cg.foodos.dto.User;
import com.cg.foodos.service.AccountService;
import com.cg.foodos.service.FoodOrderService;
import com.cg.foodos.service.FoodService;
import com.cg.foodos.service.RestaurantService;
import com.cg.foodos.service.UserService;

@RestController
@CrossOrigin(origins = "*")
public class MainController {
	@Autowired
	UserService userService;
	@Autowired
	AccountService accountService;
	@Autowired
	FoodOrderService foodOrderService;
	@Autowired
	FoodService foodService;
	@Autowired
	RestaurantService restaurantService;
	
	
	
	/*
	* Author: 
	* Description: ***********User***********
	* Created: October 14, 2019
	* Input: 
	* Output: 
	*
	*/
	@GetMapping(value = "/user-getall")
	public  ResponseEntity<List<User>> getUsers() {
		return new ResponseEntity<List<User>>(userService.findAll(), HttpStatus.FOUND);
	}
	
	@PutMapping(value = "/user-update")
	public  boolean updateUser(@RequestBody User user) {
		
			userService.save(user);
		return true;
	}
	@DeleteMapping(value = "/user-delete")
	public  boolean removeUser(@RequestParam Integer userId) {
		userService.deleteById(userId);
		return true;
	}
	
	/*
	* Author: 
	* Description: ***********Account***********
	* Created: November, 2019
	* Input: 
	* Output: 
	*
	*/
	@GetMapping(value = "/account-getall")
	public  ResponseEntity<List<Account>> getAccounts() {
		return new ResponseEntity<List<Account>>( accountService.findAll(), HttpStatus.FOUND);
	}
	
	@PutMapping(value = "/account-update")
	public  boolean updateAccount(@RequestBody Account account) {
		
			accountService.save(account);
		return true;
	}
	@DeleteMapping(value = "/account-delete")
	public  boolean removeAccount(@RequestParam Integer accountId) {
		accountService.deleteById(accountId);
		return true;
	}
	
	/*
	* Author: 
	* Description: ***********Food***********
	* Created: November, 2019
	* Input: 
	* Output: 
	*
	*/
	@GetMapping(value = "/food-getall")
	public  ResponseEntity<List<Food>> getFoods() {
		return new ResponseEntity<List<Food>>( foodService.findAll(), HttpStatus.FOUND);
	}
	
	@PutMapping(value = "/food-update")
	public  boolean updateFood(@RequestBody Food Food) {
		
			foodService.save(Food);
		return true;
	}
	@DeleteMapping(value = "/food-delete")
	public  boolean removeFood(@RequestParam Integer FoodId) {
		foodService.deleteById(FoodId);
		return true;
	}
	
	/*
	* Author: 
	* Description: ***********Restaurant***********
	* Created: November, 2019
	* Input: 
	* Output: 
	*
	*/
	@GetMapping(value = "/Restaurant-getall")
	public  ResponseEntity<List<Restaurant>> getRestaurants() {
		return new ResponseEntity<List<Restaurant>>( restaurantService.findAll(), HttpStatus.FOUND);
	}
	
	@PutMapping(value = "/restaurant-update")
	public  boolean updateRestaurant(@RequestBody Restaurant restaurant) {
			restaurantService.save(restaurant);
		return true;
	}
	@DeleteMapping(value = "/restaurant-delete")
	public  boolean removeRestaurant(@RequestParam Integer restaurantId) {
		restaurantService.deleteById(restaurantId);
		return true;
	}
}
