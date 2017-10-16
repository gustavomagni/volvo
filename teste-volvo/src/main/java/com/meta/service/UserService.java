package com.meta.service;

import java.util.List;

import com.meta.entity.User;

public interface UserService {

	User findById(int id);
	
	void save(User employee);
	
	void update(User employee);		

	List<User> findAll(); 
	
	void deleteById(Integer id);
}
