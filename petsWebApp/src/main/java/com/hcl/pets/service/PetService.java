package com.hcl.pets.service;

public interface PetService {

	public Object getAllPets();
	
	public Object getMyPets(long userId);
	
	public Object petDetail(long petId);
	
}
