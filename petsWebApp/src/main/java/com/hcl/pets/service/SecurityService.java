package com.hcl.pets.service;

import com.hcl.pets.bean.LoginBean;

public interface SecurityService {

	public String authenticateUser(LoginBean loginBean);
}
