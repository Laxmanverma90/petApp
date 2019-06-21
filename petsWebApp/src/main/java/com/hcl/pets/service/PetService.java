package com.hcl.pets.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.hcl.pets.bean.PetBean;
import com.hcl.pets.model.Pet;

public interface PetService {

	public List<PetBean> getAllPets();
	
	public Optional<Pet> getMyPets(long userId);
	
	public Object petDetail(long petId);
	
	public String buyPet(long buyPetId, int userId);
	
	public String addMyPet(Pet pet);
	
	public Optional<Pet> searchPet(String petName, int petAge, String petPlace);
	
}
