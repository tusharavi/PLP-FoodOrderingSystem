package com.cg.foodos.service;

import java.util.List;

import com.cg.foodos.dto.User;

public interface UserService {
	public List<User> save(User user);
	public List<User> findAll() ;
	public void delete(User user);
	public User findById(Integer userId);
	public void deleteById(Integer userId);
	public User findByUsername(String username);
}
