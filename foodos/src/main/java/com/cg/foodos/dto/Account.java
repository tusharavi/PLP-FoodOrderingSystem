package com.cg.foodos.dto;


import java.util.*;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 */
@Entity
public class Account {
    
    /**
     * 
     */
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer accountId;

    @ElementCollection
    private List<Address> addresses;
    
    @OneToMany(mappedBy = "account")
	@JsonIgnore
    private List<FoodOrder> foods;
    @OneToOne(mappedBy = "account")
    private User user;
    
    
    /**
     * Default constructor
     */
    public Account() {
    }

    /**
     * Default constructor
     */
    public Account(Integer accountId, List<Address> addresses, List<FoodOrder> foods, User user) {
		super();
		this.accountId = accountId;
		this.addresses = addresses;
		this.foods = foods;
		this.user = user;
	}
	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<FoodOrder> getFoods() {
		return foods;
	}

	public void setFoods(List<FoodOrder> foods) {
		this.foods = foods;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Account other = (Account) obj;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

}