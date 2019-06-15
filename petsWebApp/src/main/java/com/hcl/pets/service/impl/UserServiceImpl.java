package com.hcl.pets.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.pets.bean.UserRegistration;
import com.hcl.pets.model.User;
import com.hcl.pets.repository.UserRepository;
import com.hcl.pets.service.UserService;

/**
 * 
 * @author Laxman verma
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	/**
	 * @param userRegistration return String
	 */
	@Override
	public String addUser(UserRegistration userRegistration) {

		User existingUser = null;
		String successMessage = null;
		try {
			if (userRegistration != null) {
				if (userRegistration.getPassword().equals(userRegistration.getComfirmPassword())) {
					existingUser = findUserByName(userRegistration.getUserName());
					if (existingUser == null) {
						User user = new User();
						user.setUserName(userRegistration.getUserName());
						user.setUserPass(userRegistration.getPassword());
						if (userRepository.save(user) != null) {
							successMessage = "User Registration successful.";
						} else {
							successMessage = "User Registration Unsuccessful.";
						}
					} else {
						successMessage = "User name already exist.";
					}
				} else {
					successMessage = "Password & Confirm password doesn't match!!";
				}
			}
		} catch (Exception e) {
			successMessage = "ERROR :: Went something wrong : " + e;
		}
		return successMessage;
	}

	@Override
	public User findUserByName(String userName) {
		return userRepository.findUserByName(userName);
	}

}
