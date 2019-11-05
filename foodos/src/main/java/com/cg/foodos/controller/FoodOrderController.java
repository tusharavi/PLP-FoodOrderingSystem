package com.cg.foodos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	
	@GetMapping(value = "/user-orders")
	public  ResponseEntity<List<FoodOrder>> getUserOrders(@RequestParam Integer accountId) {
		List<FoodOrder> foodOrders = accountService.findById(accountId).getFoodOrders();
		return new ResponseEntity<List<FoodOrder>>(foodOrders, HttpStatus.FOUND);
	}
	@GetMapping(value = "/restaurant-orders")
	public  ResponseEntity<List<FoodOrder>> getRestaurantOrders(@RequestParam Integer restaurantId) {
		List<FoodOrder> foodOrders = restaurantService.findById(restaurantId).getFoodOrders();
		return new ResponseEntity<List<FoodOrder>>(foodOrders, HttpStatus.FOUND);
	}
	@GetMapping(value = "/food-order")
	public  ResponseEntity<FoodOrder> getFoodOrders(@RequestParam Integer foodId) {
		FoodOrder foodOrders = foodService.findById(foodId).getFoodOrder();
		return new ResponseEntity<FoodOrder>(foodOrders, HttpStatus.FOUND);
	}
	
	
	
}
