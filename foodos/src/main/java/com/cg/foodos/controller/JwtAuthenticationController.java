package com.cg.foodos.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.foodos.configuration.JwtTokenUtil;
import com.cg.foodos.dto.User;
import com.cg.foodos.model.*;
import com.cg.foodos.service.JwtUserDetailsServiceImpl;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class JwtAuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsServiceImpl userDetailsService;
	
	@PostMapping(value = "/signup")
	public ResponseEntity<?> saveUser(@RequestBody User user) throws Exception {
		user.setRoles("ROLE_CUSTOMER");
		System.out.println("here");
		return ResponseEntity.ok(userDetailsService.save(user));
	}
	@PostMapping(value = "/login")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		
		System.out.println(authenticationRequest.getUsername());

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		
		System.out.println("token generation");
		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());
		
		System.out.println(userDetails.getPassword());
		final String token = jwtTokenUtil.generateToken(userDetails);
		System.out.println("done here");

		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	private void authenticate(String username, String password) throws Exception {
		try {
			System.out.println("inside authenticate");
			UsernamePasswordAuthenticationToken tok=  new UsernamePasswordAuthenticationToken(username, password,new ArrayList<>());
			System.out.println(tok);
			authenticationManager.authenticate(tok);
			System.out.println("done");
		} catch (DisabledException e) {
			System.out.println("disabled");
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			System.out.println("bad");
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

}