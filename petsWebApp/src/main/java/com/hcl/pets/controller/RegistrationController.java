package com.hcl.pets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.pets.bean.UserRegistration;
import com.hcl.pets.service.UserService;

/**
 * @author Laxman verma
 *
 */
@RestController
@RequestMapping("/registration")
public class RegistrationController {

	@Autowired
	private UserService userService;
	
	/**
	 * @param userRegistration
	 * @return String
	 */
	@PostMapping("/addUser")
	public String addUser(@RequestBody UserRegistration userRegistration) {
		
		return userService.addUser(userRegistration);
	}
}
