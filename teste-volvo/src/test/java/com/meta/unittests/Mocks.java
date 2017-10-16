package com.meta.unittests;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.context.MessageSource;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.meta.entity.User;
import com.meta.rest.UserRest;
import com.meta.service.UserService;

public class Mocks {

	@Mock
	UserService service;
	
	@Mock
	MessageSource message;
	
	@InjectMocks
	UserRest userRest;
	
	@Spy
	List<User> users = new ArrayList<User>();

	@Spy
	ModelMap model;
	
	@Mock
	BindingResult result;
	
	@BeforeClass
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		users = getAll();
	}
	
	@Test
	public void listAll(){
		when(service.findAll()).thenReturn(users);
		Assert.assertEquals(userRest.listAll(model), "allusers");
		Assert.assertEquals(model.get("users"), users);
		verify(service, atLeastOnce()).findAll();
	}
		
	@Test
	public void save(){
		when(result.hasErrors()).thenReturn(false);		
		doNothing().when(service).save(any(User.class));
		Assert.assertEquals(userRest.saveUser(users.get(0), result, model), "success");
	}

	@Test
	public void update(){
		when(result.hasErrors()).thenReturn(false);		
		doNothing().when(service).update(any(User.class));
		Assert.assertEquals(userRest.update(users.get(0), result, model, 0), "success");
	}
	 
	
	@Test
	public void delete(){
		doNothing().when(service).deleteById(anyInt());
		Assert.assertEquals(userRest.deleteUser(123), "redirect:/listAll");
	}

	public List<User> getAll(){
		User e1 = new User();
		e1.setId(1);
		e1.setName("Gustavo");
		
		e1.setDescription(anyString());
		e1.setPermission(10);
		
		User e2 = new User();
		e2.setId(2);
		e2.setName("Meta");
		
		e2.setDescription(anyString());
		e2.setPermission(anyInt());
		
		users.add(e1);
		users.add(e2);
		return users;
	}
}
