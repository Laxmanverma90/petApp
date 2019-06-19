package com.hcl.pets.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.pets.bean.PetBean;
import com.hcl.pets.model.Pet;
import com.hcl.pets.service.PetService;

@RestController
@RequestMapping("/pets")
public class PetController {

	@Autowired
	private PetService petService;

	@GetMapping("/")
	public ResponseEntity<List<PetBean>> petHome() {
		return ResponseEntity.status(HttpStatus.OK).body(petService.getAllPets());
	}

	@GetMapping("/myPets/{userId}")
	public Object myPets(@PathVariable long userId) {
		return petService.getMyPets(userId);
	}

	@GetMapping("/petDetail/{petId}")
	public Object petDetail(@PathVariable long petId) {
		return petService.petDetail(petId);
	}

	@PutMapping("/petBuy/{petId}/{userId}")
	public Object buyPet(@RequestParam("petId") long petId, @RequestParam("userId") int userId) {
		return petService.buyPet(petId, userId);
	}

	@PostMapping("/addPet")
	public String addPet(@RequestBody Pet pet) {
		return petService.addMyPet(pet);
	}

	@GetMapping("/searchPet")
	public ResponseEntity<Optional<Pet>> searchPets(@RequestParam("petName") String petName,
			@RequestParam("petAge") int petAge, @RequestParam("petPlace") String petPlace) {
		ResponseEntity<Optional<Pet>> respEntiry = null;
		Optional<Pet> petList = petService.searchPet(petName, petAge, petPlace);
		if (petList != null && petList.isPresent()) {
			respEntiry = new ResponseEntity<Optional<Pet>>(petList, HttpStatus.OK);
		} else {
			respEntiry = new ResponseEntity<Optional<Pet>>(HttpStatus.NO_CONTENT);
		}
		return respEntiry;
	}
}
