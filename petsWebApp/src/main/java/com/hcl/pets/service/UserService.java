package com.hcl.pets.service;

import com.hcl.pets.bean.UserRegistration;
import com.hcl.pets.model.User;

public interface UserService {

	public String addUser(UserRegistration userRegistration);
	
	public User findUserByName(String userName);
}
