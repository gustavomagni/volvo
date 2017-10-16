package com.meta.persist;

import java.util.List;

import com.meta.entity.User;

public interface UserRepository {

	User findById(int id);

	void save(User employee);	
	
	List<User> findAll();
	
	public void removerById(Integer id);
}
