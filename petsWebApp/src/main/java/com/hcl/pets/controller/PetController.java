package com.hcl.pets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.pets.service.PetService;

@RestController
@RequestMapping("/pets")
public class PetController {

	@Autowired
	private PetService petService;
	
	@GetMapping("/")
	public Object petHome(){
		return petService.getAllPets();
	}
	
	@GetMapping("/myPets/{userId}")
	public Object myPets(@PathVariable long userId){
		
		return petService.getMyPets(userId);
	}
	
	@GetMapping("/petDetail/{petId}")
	public Object petDetail(@PathVariable long petId) {
		return petService.petDetail(petId);
	}
}
