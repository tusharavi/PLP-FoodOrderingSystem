package com.cg.foodos.service;

import com.cg.foodos.dto.FoodOrder;

public interface FoodOrderService {
	public void save(FoodOrder foodOrder);
	public FoodOrder cancelOrder(Integer orderId);
//	public List<FoodOrder> findAllByAccountId(Integer accountId);
//	public List<FoodOrder> findAllByRestaurantId(Integer restaurantId);
}
