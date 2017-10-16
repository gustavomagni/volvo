package com.meta.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meta.entity.User;
import com.meta.persist.UserRepository;

@Service("userService")
@Transactional(rollbackOn = {Exception.class, HibernateException.class})
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repository;
	
	
	public User findById(int id) {
		return repository.findById(id);
	}

	public void save(User user) {
		repository.save(user);
	}

	public void update(User user) {
		User userEntity = repository.findById(user.getId());
		
		if(userEntity!=null){
			userEntity.setName(user.getName());	
			userEntity.setDescription(user.getDescription());
			userEntity.setPermission(user.getPermission());		
		}
	}

	public List<User> findAll() {
		return repository.findAll();
	}

	public void deleteById(Integer id) {
		repository.removerById(id);
	}

}
