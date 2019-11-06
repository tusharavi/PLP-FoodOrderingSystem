package com.cg.foodos.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.foodos.dto.User;
import com.cg.foodos.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	
	@Override
	public User save(User user) {
		
		return null;
	}

	@Override
	public List<User> findAll() {
		
		return null;
	}

	@Override
	public void delete(User user) {
		
		
	}

	@Override
	public User findById(Integer userId) {
		
		return null;
	}

	@Override
	public void deleteById(Integer userId) {
		userRepository.deleteById(userId);
		return;
	}

	@Override
	public User findByUsernameAndPassword(String username, String password) {
		List<User> users = userRepository.findByUsername(username);
		User user;
		Iterator<User> iterator = users.iterator();
		
		while(iterator.hasNext()) {
		   user = iterator.next();
		   if(user.getPassword() == password) {
			   return user;
		   }
		}
		return null; // In case the user is not found
	}

}
