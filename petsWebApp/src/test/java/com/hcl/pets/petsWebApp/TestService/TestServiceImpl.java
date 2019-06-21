package com.hcl.pets.petsWebApp.TestService;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import com.hcl.pets.bean.PetBean;
import com.hcl.pets.model.Pet;
import com.hcl.pets.repository.PetRepository;
import com.hcl.pets.service.impl.PetServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class TestServiceImpl {

	@InjectMocks
	PetServiceImpl petServiceImpl;

	@Mock
	PetRepository petRepository;

	@Mock
	ModelMapper modelMapper;

	/*
	 * @Mock PetBean pet;
	 */

	/*
	 * @Mock Pet pet;
	 */

	@Test
	public void testGetAllPets() {
		List<Pet> listPet = new ArrayList<Pet>();
		Pet pet = new Pet();
		pet.setId(123);
		pet.setPetAge(23);
		pet.setPetName("mon");
		pet.setPetOwnerId(1);
		pet.setPetPlace("Bangalore");
		listPet.add(pet);

		List<PetBean> listBeanPet = new ArrayList<PetBean>();
		PetBean petBean = new PetBean();
		petBean.setId(123);
		petBean.setPetAge(23);
		petBean.setPetName("mon");
		petBean.setPetOwnerId(1);
		petBean.setPetPlace("Bangalore");
		listBeanPet.add(petBean);

		Mockito.when(petRepository.findAll()).thenReturn(listPet);
		Mockito.when(modelMapper.map(pet, PetBean.class)).thenReturn(petBean);
		List<PetBean> petList = petServiceImpl.getAllPets();
		assertEquals(petList.size(), listPet.size());
	}

	@Test
	public void saveTest() {

		String actualmessage = "Pet added successfully";
		Pet petBean = new Pet();
		petBean.setId(123);
		petBean.setPetAge(23);
		petBean.setPetName("mon");
		petBean.setPetOwnerId(1);
		petBean.setPetPlace("Bangalore");

		Mockito.when(petRepository.save(petBean)).thenReturn(petBean);
		String returnMessage = petServiceImpl.addMyPet(petBean);
		assertEquals(returnMessage, actualmessage);
	}

	@Test
	public void getMyPetsTest() {

	}

}
