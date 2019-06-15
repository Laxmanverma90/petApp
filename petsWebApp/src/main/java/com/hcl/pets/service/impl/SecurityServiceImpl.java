package com.hcl.pets.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.pets.bean.LoginBean;
import com.hcl.pets.model.User;
import com.hcl.pets.service.SecurityService;
import com.hcl.pets.service.UserService;

/**
 * @author Laxman verma
 *
 */
@Service
public class SecurityServiceImpl implements SecurityService {

	@Autowired
	private UserService userService;
	
	/**
	 * @param loginBean
	 * return String
	 */
	@Override
	public String authenticateUser(LoginBean loginBean) {
		
		User user = null;
		String successMessage = null;
		try {
			if(loginBean !=null ) {
				user = userService.findUserByName(loginBean.getUserName());
				if(user !=null) {
					if(loginBean.getUserPassword().equals(user.getUserPass())) {
						successMessage = "Congrats! Login success";
					}else {
						successMessage = "User name or password is incorrect";
					}
				}else {
					successMessage = "Sorry! User doesn't exist";
				}
			} else {
				successMessage = "Please enter User name and Password !!";
			}
		} catch (Exception e) {
			successMessage = "ERROR :: soththing went worng : "+e;
		}
		return successMessage;
	}

}
