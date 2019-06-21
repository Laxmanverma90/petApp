package com.hcl.pets.petsWebApp.TestService;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.hcl.pets.bean.PetBean;
import com.hcl.pets.controller.PetController;
import com.hcl.pets.model.Pet;
import com.hcl.pets.service.impl.PetServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class PetControllerTest {

	@InjectMocks
	private PetController petController;

	@Mock
	private PetServiceImpl petServiceImpl;

	private MockMvc mockMvc;
	
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(petController).build(); 
	}

	@Test
	public void testGetAllPets() {
		List<PetBean> petBeanList = new ArrayList<>();
		PetBean pet = new PetBean();
		pet.setId(123);
		pet.setPetAge(23);
		pet.setPetName("mon");
		pet.setPetOwnerId(1);
		pet.setPetPlace("Bangalore");
		petBeanList.add(pet);
//		ResponseEntity<List<PetBean>> respPteList = ResponseEntity.status(HttpStatus.OK).body(petService.getAllPets());
		Mockito.when(petServiceImpl.getAllPets()).thenReturn(petBeanList);
		try {
			mockMvc.perform(get("/pets/"))
				.andExpect(status().isOk())
				.andExpect((ResultMatcher) content().contentType(MediaType.APPLICATION_JSON_UTF8));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Test
	public void getMyPetsTest()
	{
		PetBean pet = new PetBean();
		pet.setId(123);
		pet.setPetAge(23);
		pet.setPetName("mon");
		pet.setPetOwnerId(1);
		pet.setPetPlace("Bangalore");
		
		Mockito.when(petServiceImpl.getMyPets(Mockito.anyLong()));
	}

}
