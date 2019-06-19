package com.hcl.pets.controller;

import javax.persistence.PostRemove;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.pets.bean.LoginBean;
import com.hcl.pets.service.SecurityService;

@RestController
@RequestMapping("/")
public class SecurityController {

	@Autowired
	private SecurityService securityService;
	
	@PostMapping("/user/authenticate")
	public ResponseEntity<String> authenticateUser(@RequestBody LoginBean loginBean) {
		
		return new ResponseEntity<String>(securityService.authenticateUser(loginBean),HttpStatus.OK);
	}
}
