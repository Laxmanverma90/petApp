package com.hcl.pets.petsWebApp.TestService;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.pets.bean.UserRegistration;
import com.hcl.pets.controller.RegistrationController;
import com.hcl.pets.service.UserService;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class RegisterControllerTest {

	@Mock
	private UserService userService;
	
	private MockMvc mockMvc;
	
	@InjectMocks
	private RegistrationController regController;
	
	@Autowired
	private WebApplicationContext context;

	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(regController).build(); 
				//MockMvcBuilders.webAppContextSetup(context).build();
	}
	
		
	@Test
	public void testAddUser()	
	{
		UserRegistration userRegister = new UserRegistration();
		userRegister.setUserName("sonee");
		userRegister.setPassword("sonnee123");
		userRegister.setComfirmPassword("sonnee123");
		
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonObject= null;
		try {
			 jsonObject= objectMapper.writeValueAsString(userRegister);
			Mockito.when(userService.addUser(userRegister)).thenReturn(jsonObject);
			mockMvc.perform(post("/registration/addUser").contentType(MediaType.APPLICATION_JSON)
				.content(jsonObject)).andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ResponseEntity<String>  respEntity = regController.addUser(userRegister);
		assertEquals(jsonObject, respEntity.getBody());
		
	}
}
