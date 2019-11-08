package com.cg.foodos.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	* Description: ***********BASIC***********
	* Created: October 14, 2019
	* Input: 
	* Output: 
	*
	*/
	
	@GetMapping(value = "/login")
	public  ResponseEntity<User> logIn(@RequestParam("username") String username, @RequestParam("password") String password) {
		User user = userService.findByUsernameAndPassword(username, password);
		if(user!=null) {
			return new ResponseEntity<User>(user, HttpStatus.FOUND);
		}
		else {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping(value = "/sign-up")
	public ResponseEntity<User> signUp(@RequestBody User user) {
		user.setRole("ROLE_CUSTOMER");
		userService.save(user);
		return new ResponseEntity<User>(user, HttpStatus.FOUND);
	}
	
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
	@PostMapping(value = "/user-add") 
	public ResponseEntity<List<User>> addUser(@RequestBody User user, BindingResult result) {
		User userFound = userService.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		if(result.hasErrors() || userFound == null) {
			return new ResponseEntity<List<User>>(HttpStatus.NOT_ACCEPTABLE);
		}
		
		userService.save(user);
		return new ResponseEntity<List<User>>(userService.findAll(), HttpStatus.OK);
	}
	@PutMapping(value = "/user-update/{userId}")
	public ResponseEntity<List<User>> updateUser(@PathVariable Integer userId, @RequestBody User user) {
		User userFound = userService.findById(userId);
		userFound.setEmail(user.getEmail());
		userFound.setPassword(user.getPassword());
		userFound.setTelephone(user.getTelephone());
		userFound.setUsername(user.getUsername());
		return new ResponseEntity<List<User>>(userService.findAll(), HttpStatus.OK);
	}
	@DeleteMapping(value = "/user-delete/{userId}")
	public  ResponseEntity<List<User>> removeUser(@PathVariable Integer userId) {
		userService.deleteById(userId);
		return new ResponseEntity<List<User>>(userService.findAll(), HttpStatus.OK) ;
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
	@PostMapping(value = "/account-add") // Page for adding Account to database
	public ResponseEntity<List<Account>> addAccount(@RequestBody Account account, BindingResult result) {
		if(result.hasErrors()) {
			return new ResponseEntity<List<Account>>(HttpStatus.NOT_ACCEPTABLE);
		}
		accountService.save(account);
		return new ResponseEntity<List<Account>>( accountService.findAll(), HttpStatus.OK);
	}
	@PutMapping(value = "/account-update/{accountId}")
	public  boolean updateAccount(@PathVariable Integer accountId, @RequestBody Account account) {		
			accountService.save(account);
		return true;
	}
	@DeleteMapping(value = "/account-delete/{accountId}")
	public  boolean removeAccount(@PathVariable Integer accountId) {
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
	@PostMapping(value = "/food-add")
	public  ResponseEntity<List<Food>> addFood(@RequestBody Food food, BindingResult result) {
			if(result.hasErrors()) {
				return new ResponseEntity<List<Food>>(HttpStatus.NOT_ACCEPTABLE);
			}
			foodService.save(food);
		return new ResponseEntity<List<Food>>( foodService.findAll(), HttpStatus.CREATED);
	}
	@PutMapping(value = "/food-update/{foodId}")
	public  ResponseEntity<List<Food>> updateFood(@PathVariable Integer foodId, @RequestBody Food food, BindingResult result) {
			if(result.hasErrors()) {
				return new ResponseEntity<List<Food>>(HttpStatus.NOT_ACCEPTABLE);
			}
			Food foodFound = foodService.findById(foodId);
			foodFound.setEnumFoodType(food.getEnumFoodType());
			foodFound.setFoodName(food.getFoodName());
			foodFound.setVegetarian(food.getVegetarian());
		return new ResponseEntity<List<Food>>( foodService.findAll(), HttpStatus.OK);
	}
	@DeleteMapping(value = "/food-delete/{foodId}")
	public  ResponseEntity<List<Food>> removeFood(@PathVariable Integer foodId) {
		foodService.deleteById(foodId);
		return new ResponseEntity<List<Food>>( foodService.findAll(), HttpStatus.OK);
	}
	
	/*
	* Author: 
	* Description: ***********Restaurant***********
	* Created: November, 2019
	* Input: 
	* Output: 
	*
	*/
	@GetMapping(value = "/restaurant-getall")
	public  ResponseEntity<List<Restaurant>> getRestaurants() {
		return new ResponseEntity<List<Restaurant>>( restaurantService.findAll(), HttpStatus.FOUND);
	}
	@PostMapping(value = "/restaurant-add")
	public  ResponseEntity<List<Restaurant>> addRestaurants(@RequestBody Restaurant restaurant, BindingResult result) {
		if(result.hasErrors()) {
			return new ResponseEntity<List<Restaurant>>(HttpStatus.NOT_ACCEPTABLE);
		} else {
			restaurantService.save(restaurant);
		}
		return new ResponseEntity<List<Restaurant>>( restaurantService.findAll(), HttpStatus.CREATED);
	}
	@PutMapping(value = "/restaurant-update/{restaruantId}")
	public  ResponseEntity<List<Restaurant>> updateRestaurant(@PathVariable Integer restaurantId, @RequestBody Restaurant restaurant) {
		Restaurant restaurantFound = restaurantService.findById(restaurantId);
		restaurantFound.setRestaurantName(restaurant.getRestaurantName());
		restaurantFound.setAddress(restaurant.getAddress());
		return new ResponseEntity<List<Restaurant>>( restaurantService.findAll(), HttpStatus.OK);
	}
	@DeleteMapping(value = "/restaurant-delete/{restaruantId}")
	public  ResponseEntity<List<Restaurant>> removeRestaurant(@PathVariable Integer restaurantId) {
		restaurantService.deleteById(restaurantId);
		return new ResponseEntity<List<Restaurant>>( restaurantService.findAll(), HttpStatus.OK);
	}
}
