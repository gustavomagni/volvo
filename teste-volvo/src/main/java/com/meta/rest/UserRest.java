package com.meta.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.meta.entity.User;
import com.meta.service.UserService;

@Controller
@RequestMapping("/")
public class UserRest {

	@Autowired
	UserService service;

	@RequestMapping(value = { "/", "/findAll" }, method = RequestMethod.GET)
	public String listAll(ModelMap model) {

		List<User> users = service.findAll();
		model.addAttribute("users", users);

		return "allusers";
	}

	@RequestMapping(value = { "/save" }, method = RequestMethod.POST)
	public String saveUser(@Valid User user, BindingResult result,
			ModelMap model) {
		service.save(user);
		return "success";
	}

	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.POST)
	public String update(@Valid User user, BindingResult result,
			ModelMap model, @PathVariable Integer id) {

		service.update(user);

		return "success";
	}


	@RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.GET)
	public String deleteUser(@PathVariable Integer id) {
		service.deleteById(id);
		return "redirect:/findAll";
	}
}
