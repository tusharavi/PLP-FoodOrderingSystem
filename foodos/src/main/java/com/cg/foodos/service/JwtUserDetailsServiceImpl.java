package com.cg.foodos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cg.foodos.dto.JwtUserDetailsImpl;
import com.cg.foodos.dto.User;
import com.cg.foodos.repository.UserRepository;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
@SuppressWarnings("unused")
public class JwtUserDetailsServiceImpl implements UserDetailsService {
	
	private static final Logger logger = LoggerFactory.getLogger(JwtUserDetailsServiceImpl.class);
	
	@Autowired 
	private PasswordEncoder bycryptEncoder; 
	@Autowired
	UserService service = new UserServiceImpl();
	@Autowired
	private JwtUserDetailsImpl userDetails;

	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> user;
		try {
			System.out.println(username);
			user = Optional.of(service.findByUsername(username));
			System.out.println(user.get().getTelephone());
			user.orElseThrow(() -> new UsernameNotFoundException("Not Found: "+username));
			return user.map(JwtUserDetailsImpl::new).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return null;

	}

		
	public User save(User user) {
		User newUser = new User();
		newUser.setUsername(user.getUsername());
		newUser.setRoles("ROLE_CUSTOMER");
		newUser.setEmail(user.getEmail());
		newUser.setTelephone(user.getTelephone());
		newUser.setPassword(bycryptEncoder.encode(user.getPassword()));
		System.out.println(user.toString());
		return userRepository.save(newUser);
	}



}