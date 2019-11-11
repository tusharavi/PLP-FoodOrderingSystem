package com.cg.foodos.service;

import com.cg.foodos.dto.FoodOrder;

public interface FoodOrderService {
	public boolean save(FoodOrder foodOrder, Integer foodId, Integer accountId);
	public boolean cancelOrder(Integer orderId);
}
