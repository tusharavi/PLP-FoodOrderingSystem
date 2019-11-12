package com.cg.foodos.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.foodos.dto.Food;
import com.cg.foodos.dto.FoodOrder;
import com.cg.foodos.service.AccountService;
import com.cg.foodos.service.FoodOrderService;
import com.cg.foodos.service.FoodService;
import com.cg.foodos.service.RestaurantService;
import com.cg.foodos.service.UserService;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "*")
public class FoodOrderController {
	@Autowired
	AccountService accountService;
	@Autowired
	FoodOrderService foodOrderService;
	@Autowired
	FoodService foodService;
	@Autowired
	RestaurantService restaurantService;
	@Autowired
	UserService userService;

	
	@PostMapping(value = "/add")
	public  ResponseEntity<FoodOrder> placeOrder(@RequestBody FoodOrder foodOrder, 
			@RequestParam Integer accountId,
			@RequestParam Integer foodId,
			BindingResult result) {
		if(result.hasErrors()) {
			return new ResponseEntity<FoodOrder>(HttpStatus.NOT_ACCEPTABLE);
		}
		foodOrder.setAccount(accountService.findById(accountId));
		
		List<Food> foods = new ArrayList<Food>();
		foods.add(foodService.findById(foodId).get());
		foodOrder.setFoods(foods );
		foodOrderService.save(foodOrder);
		return new ResponseEntity<FoodOrder>(foodOrder, HttpStatus.ACCEPTED);
	}
	@DeleteMapping(value = "/delete/{orderId}")
	public  ResponseEntity<List<FoodOrder>> updateOrder(@PathVariable Integer accountId) {
		List<FoodOrder> foodOrders = accountService.findById(accountId).getFoodOrders();
		return new ResponseEntity<List<FoodOrder>>(foodOrders, HttpStatus.FOUND);
	}
	@GetMapping(value = "/user-order/{userId}")
	public  ResponseEntity<List<FoodOrder>> cancelOrder(@PathVariable Integer accountId) {
		List<FoodOrder> foodOrders = accountService.findById(accountId).getFoodOrders();
		return new ResponseEntity<List<FoodOrder>>(foodOrders, HttpStatus.FOUND);
	}
	@GetMapping(value = "/restaurant-order/{restaurantId}")
	public  ResponseEntity<List<FoodOrder>> getRestaurantOrders(@PathVariable Integer restaurantId) {
		List<FoodOrder> foodOrders = restaurantService.findById(restaurantId).get().getFoodOrders();
		return new ResponseEntity<List<FoodOrder>>(foodOrders, HttpStatus.FOUND);
	}
	@GetMapping(value = "/food-order/{foodId}")
	public  ResponseEntity<List<FoodOrder>> getFoodOrders(@PathVariable Integer foodId) {
		List<FoodOrder> foodOrders = foodService.findById(foodId).get().getFoodOrders();
		return new ResponseEntity<List<FoodOrder>>(foodOrders, HttpStatus.FOUND);
	}
	

}
