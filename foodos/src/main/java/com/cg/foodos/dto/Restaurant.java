package com.cg.foodos.dto;


import java.util.*;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 */
@Entity
public class Restaurant {

    /**
     * 
     */
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer restaurantId;
	
	private String restaurantName;
	
    @Embedded
    private Address address;
    
    @OneToMany(mappedBy = "restaurant")
    @JsonIgnore
    List<FoodOrder> foodOrders;
    
    @OneToMany(mappedBy = "restaurant")
    @JsonIgnore
    private List<Food> foods;
    
    /**
     * Default constructor
     */
    public Restaurant() {
    }
    
    /**
     * Fields constructor
     */
    public Restaurant(Integer restaurantId, List<Food> foods, Address address) {
		super();
		this.restaurantId = restaurantId;
		this.foods = foods;
		this.address = address;
	}
	

	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	public List<Food> getFoods() {
		return foods;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public void setFoods(List<Food> foods) {
		this.foods = foods;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", foods=" + foods + ", address=" + address + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((foods == null) ? 0 : foods.hashCode());
		result = prime * result + ((restaurantId == null) ? 0 : restaurantId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Restaurant other = (Restaurant) obj;
		if (foods == null) {
			if (other.foods != null)
				return false;
		} else if (!foods.equals(other.foods))
			return false;
		if (restaurantId == null) {
			if (other.restaurantId != null)
				return false;
		} else if (!restaurantId.equals(other.restaurantId))
			return false;
		return true;
	}

	public List<FoodOrder> getFoodOrders() {
		return foodOrders;
	}

	public void setFoodOrders(List<FoodOrder> foodOrders) {
		this.foodOrders = foodOrders;
	}
	
}