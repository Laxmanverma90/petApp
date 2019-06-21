package com.hcl.pets.petsWebApp.TestService;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.pets.bean.UserRegistration;
import com.hcl.pets.repository.UserRepository;
import com.hcl.pets.service.impl.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class RegisterServiceTest {

	@Mock
	private UserRepository userRepo;
	
	@InjectMocks
	private UserServiceImpl userServiceImpl;
	/*
	@Test
	public void testUserRegister() {
		UserRegistration userRegister = new UserRegistration();
		userRegister.setUserName("sonee");
		userRegister.setPassword("sonnee123");
		userRegister.setComfirmPassword("sonnee123");
		when(userRepo.save(userRegister)).thenR
	}*/
}
