package com.hcl.pets.bean;

public class UserRegistration {

	private String userName;
	private String password;
	private String comfirmPassword;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getComfirmPassword() {
		return comfirmPassword;
	}

	public void setComfirmPassword(String comfirmPassword) {
		this.comfirmPassword = comfirmPassword;
	}

	@Override
	public String toString() {
		return "UserRegistration [userName=" + userName + ", password=" + password + ", comfirmPassword="
				+ comfirmPassword + "]";
	}
}