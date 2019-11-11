package com.cg.foodos.service;

import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.foodos.dto.User;
import com.cg.foodos.repository.UserRepository;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	
	@Override
	public List<User> save(User user) {
		userRepository.save(user);
		System.out.println("user"+user.getUsername());
		return userRepository.findByUsername(user.getUsername());
	}

	@Override
	public List<User> findAll() {
		
		return userRepository.findAll();
	}

	@Override
	public void delete(User user) {
		userRepository.delete(user);
	}

	@Override
	public User findById(Integer userId) {
		return userRepository.getOne(userId);
	}

	@Override
	public void deleteById(Integer userId) {
		userRepository.deleteById(userId);
		return;
	}

	@Override
	public User findByUsername(String username) {
		List<User> users = userRepository.findByUsername(username);
		return users.get(0); // In case the user is not found
	}

}
