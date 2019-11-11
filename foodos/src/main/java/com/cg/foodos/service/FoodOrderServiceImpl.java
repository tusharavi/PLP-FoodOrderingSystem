package com.cg.foodos.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.foodos.dto.EnumOrderStatus;
import com.cg.foodos.dto.FoodOrder;
import com.cg.foodos.repository.FoodOrderRepository;

@Service("foodOrderService")
@Transactional
public class FoodOrderServiceImpl implements FoodOrderService{
	@Autowired
	FoodOrderRepository foodOrderRepository;
	
	
	/**
     * @param foodOrder
     */
    public boolean save(FoodOrder foodOrder, Integer foodId, Integer accountId) {
        foodOrderRepository.save(foodOrder);
        return true;
    }

    /**
     * @param orderId 
     * @return
     */
    public boolean cancelOrder(Integer orderId) {
        foodOrderRepository.getOne(orderId).setEnumOrderStatus(EnumOrderStatus.CANCELLED);;
        return true;
    }

    /**
     * @param orderId 
     * @return
     */
    public FoodOrder findById(Integer orderId) {
        
        return foodOrderRepository.getOne(orderId);
    }

}
