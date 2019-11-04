package com.cg.foodos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.foodos.dto.FoodOrder;
import com.cg.foodos.repository.FoodOrderRepository;

@Service("foodOrderService")
public class FoodOrderServiceImpl implements FoodOrderService{
	@Autowired
	FoodOrderRepository foodOrderRepository;
	
	
	/**
     * @param foodOrder
     */
    public void save(FoodOrder foodOrder) {
        
    }

    /**
     * @param orderId 
     * @return
     */
    public FoodOrder cancelOrder(Integer orderId) {
        
        return null;
    }

    /**
     * @param orderId 
     * @return
     */
    public FoodOrder findById(Integer orderId) {
        
        return null;
    }

//    /**
//     * @param accountid 
//     * @return
//     */
//    public List<FoodOrder> findAllByAccountId(Integer accountid) {
//        
//        return null;
//    }
//
//    /**
//     * @param restaurantId 
//     * @return
//     */
//    public List<FoodOrder> findAllByRestaurantId(Integer restaurantId) {
//        
//        return null;
//    }

}
