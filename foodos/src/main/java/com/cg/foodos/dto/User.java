package com.cg.foodos.dto;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * 
 */
@Entity
public class User {

    /**
     * 
     */
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private Integer userId;
	

	private String username;


    private String password;


    private String email;

 
    private BigInteger telephone;


    private String roles;

    @OneToOne
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;

    
    /**
     * Default constructor
     */
    public User() {
    }
    
    /**
     * Default constructor
     */
    public User(String username, String password, String email, BigInteger telephone, String roles, Account account) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.telephone = telephone;
		this.roles = roles;
		this.account = account;
	}
    
    public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
    
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigInteger getTelephone() {
		return telephone;
	}

	public void setTelephone(BigInteger telephone) {
		this.telephone = telephone;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String role) {
		this.roles = role;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", email=" + email + ", telephone="
				+ telephone + ", roles=" + roles + ", account=" + account + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
}