package com.cg.foodos.dto;


import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class FoodOrder {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderId;
    
    private Integer totalCost;
 
    @Enumerated(EnumType.STRING)
    private EnumOrderStatus enumOrderStatus;

    @Embedded
    @JsonIgnore
    private Address address;

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID")
    @JsonIgnore
    private Account account;
    
    @ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(joinColumns = @JoinColumn(name = "foodid_fk"), inverseJoinColumns = @JoinColumn(name = "orderid_fk"))
    @JsonIgnore
    private List<Food> foods;
    
    @ManyToOne
    @JoinColumn(name = "RESTAURANT_ID")
    @JsonIgnore
    private Restaurant restaurant;
    
    /**
     * Default constructor
     */
    public FoodOrder() {
    	
    }

	public FoodOrder(Integer orderId, EnumOrderStatus enumOrderStatus, List<Food> foods, Address address,
			Account account) {
		super();
		this.orderId = orderId;
		this.enumOrderStatus = enumOrderStatus;
		this.foods = foods;
		this.address = address;
		this.account = account;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public EnumOrderStatus getEnumOrderStatus() {
		return enumOrderStatus;
	}

	public void setEnumOrderStatus(EnumOrderStatus enumOrderStatus) {
		this.enumOrderStatus = enumOrderStatus;
	}

	public List<Food> getFoods() {
		return foods;
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

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((enumOrderStatus == null) ? 0 : enumOrderStatus.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
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
		FoodOrder other = (FoodOrder) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (enumOrderStatus != other.enumOrderStatus)
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		return true;
	}
	

	public Integer getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Integer totalCost) {
		this.totalCost = totalCost;
	}

	@Override
	public String toString() {
		return "FoodOrder [orderId=" + orderId + ", enumOrderStatus=" + enumOrderStatus + ", foods=" + foods
				+ ", address=" + address + ", account=" + account + "]";
	}

}