package com.hcl.pets.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.hcl.pets.bean.PetBean;
import com.hcl.pets.model.Pet;
import com.hcl.pets.repository.PetRepository;
import com.hcl.pets.service.PetService;

/**
 * @author Laxman verma
 *
 */
@Service
public class PetServiceImpl implements PetService {

	@Autowired
	private PetRepository petRepository;

	@Autowired
	ModelMapper modelMapper;

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Override
	public List<PetBean> getAllPets() {

		List<PetBean> petBeanList = new ArrayList<>();
		List<Pet> petList = petRepository.findAll();
		if (petList != null && !petList.isEmpty()) {
			petList.forEach(pet -> petBeanList.add(modelMapper.map(pet, PetBean.class)));
		} else {
			throw new CustomException("Record not found");
		}
		return petBeanList;
	}

	@Override
	public Optional<Pet> getMyPets(long userId) {
//		List<Pet> petList = null;
			Optional<Pet> petList = petRepository.findByUserId(userId);
			System.out.println(petList);
			if(!petList.isPresent()) {
				throw new CustomException("Record not found");
			}
		return petList;
	}

	@Override
	public Object petDetail(long petId) {

		Object returnObj = null;
		Optional<Pet> petDetail = null;
		try {
			petDetail = petRepository.findById(petId);
			if (petDetail != null) {
				returnObj = petDetail;
			} else {
				returnObj = "Sorry! Pet doesn't exist.";
			}
		} catch (Exception e) {
			returnObj = "Went somthing wrong.";
			e.printStackTrace();
		}
		return returnObj;
	}

	@Override
	public String buyPet(long buyPetId, int userId) {

		Object retObject = null;
		Optional<Pet> petDetails = petRepository.findById(buyPetId);

		if (petDetails != null) {
			Pet myPet = petDetails.get();
			myPet.setPetOwnerId(userId);
			retObject = petRepository.save(myPet);
		}
		if (retObject != null) {
			return "User " + userId + " buyed successfully";
		} else {
			return "Updation failed";
		}
	}

	@Override
	public String addMyPet(Pet pet) {
		Object petSaved = petRepository.save(pet);
		if (petSaved != null)
			return "Pet added successfully";
		else
			return "Pet adding failed";
	}

	@Override
	public Optional<Pet> searchPet(String petName, int petAge, String petPlace) {
		Optional<Pet> petList = null;
		try {
			petList = petRepository.findPetByNameByAgeByPlace(petName, petAge, petPlace);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return petList;
	}

}
