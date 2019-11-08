package com.cg.foodos.dto;

import java.io.Serializable;

public class JwtResponse implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7475552324418252818L;
	
	private final String jwttoken;

	public JwtResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	public String getToken() {
		return this.jwttoken;
	}
}