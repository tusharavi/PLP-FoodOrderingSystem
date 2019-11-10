package com.cg.foodos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cg.foodos.dto.User;
import com.cg.foodos.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {
	
	private static final Logger logger = LoggerFactory.getLogger(JwtUserDetailsServiceImpl.class);
	
	@Autowired
	UserRepository userRepository;
	@Autowired 
	private PasswordEncoder bycryptEncoder; 
	
	/*	
	 *  Author: Tushar
	 *  Description: Retrieves a user and maps it to a UserDetails object.
	 *  Input: User name string.
	 *  Output: UserDetails object.
	 *  Created Date: 11/10/2019
	 *  Last Modified: - 
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userRepository.findByUsername(username).get(0);
		logger.info("Finding user with username: "+username);
		if(user==null) {
			throw new UsernameNotFoundException("User not found: "+username);
		}
		logger.info("Found user with username: "+username);
		logger.info("Mapping User to UserDetails and returning.");
		return (UserDetails) user;
	}
	
	public User save(User user) {
		User newUser = new User();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bycryptEncoder.encode(user.getPassword()));
		userRepository.save(newUser);
		return newUser;
		
	}

}