package com.hcl.pets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<String> addUser(@RequestBody UserRegistration userRegistration) {
		
		return new ResponseEntity<String>(userService.addUser(userRegistration), HttpStatus.OK);
	}
}
