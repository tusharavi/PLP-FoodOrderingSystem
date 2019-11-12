package com.cg.foodos.dto;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 */
@Entity
public class Food {
    /**
     * 
     */
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer foodId;

    private String foodName;
    
    private Boolean vegetarian;
    
    private Integer foodPrice;

    
    @ManyToMany(mappedBy = "foods", cascade = CascadeType.PERSIST)
    @JsonIgnore
    private List<FoodOrder> foodOrders;
    
    @ManyToOne
    @JoinColumn(name = "RESTAURANT_ID")
    @JsonIgnore
    private Restaurant restaurant;

    /**
     * Default constructor
     */
    public Food() {
    }
    /**
     * Default constructor
     */

	public Food(Integer foodId, String foodName, List<FoodOrder> foodOrders, EnumFoodType enumFoodType, Boolean vegetarian) {
		super();
		this.foodId = foodId;
		this.foodName = foodName;
		this.foodOrders = foodOrders;
		this.enumFoodType = enumFoodType;
		this.vegetarian = vegetarian;
	}
	public Integer getFoodId() {
		return foodId;
	}
	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public List<FoodOrder> getFoodOrders() {
		return foodOrders;
	}
	public void setFoodOrders(List<FoodOrder> foodOrders) {
		this.foodOrders = foodOrders;
	}
	public EnumFoodType getEnumFoodType() {
		return enumFoodType;
	}
	public void setEnumFoodType(EnumFoodType enumFoodType) {
		this.enumFoodType = enumFoodType;
	}
	public Boolean getVegetarian() {
		return vegetarian;
	}
	public void setVegetarian(Boolean vegetarian) {
		this.vegetarian = vegetarian;
	}
    public Integer getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(Integer foodPrice) {
		this.foodPrice = foodPrice;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	@Enumerated(EnumType.STRING)
    private EnumFoodType enumFoodType;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((foodId == null) ? 0 : foodId.hashCode());
		result = prime * result + ((foodName == null) ? 0 : foodName.hashCode());
		result = prime * result + ((vegetarian == null) ? 0 : vegetarian.hashCode());
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
		Food other = (Food) obj;
		if (foodId == null) {
			if (other.foodId != null)
				return false;
		} else if (!foodId.equals(other.foodId))
			return false;
		if (foodName == null) {
			if (other.foodName != null)
				return false;
		} else if (!foodName.equals(other.foodName))
			return false;
		if (vegetarian == null) {
			if (other.vegetarian != null)
				return false;
		} else if (!vegetarian.equals(other.vegetarian))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Food [foodId=" + foodId + ", foodName=" + foodName + ", enumFoodType=" + enumFoodType + ", vegetarian="
				+ vegetarian + "]";
	}


}