package com.hcl.pets.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.pets.model.Pet;
import com.hcl.pets.repository.PetRepository;
import com.hcl.pets.service.PetService;

/**
 * @author Laxman verma
 *
 */
@Service
public class PetServiceImpl implements PetService{

	@Autowired
	private PetRepository petRepository;
	
	@Override
	public Object getAllPets() {
		
		Object returnObj = null;
		List<Pet> petList = null;
		try {
			petList = petRepository.findAll();
			System.out.println("petList : "+petList);
			if(petList != null) {
				returnObj = petList;
			} else {
				returnObj = "!!Welcome to Home page !!";
			}
		} catch (Exception e) {
			returnObj = "Went somthing wrong ";
			e.printStackTrace();
		}
		return returnObj;
	}

	@Override
	public Object getMyPets(long userId) {
		Object returnObj = null;
		List<Pet> petList = null;
		try {
			petList = petRepository.findByUserId(String.valueOf(userId));
			System.out.println(petList);
			
			if(petList != null) {
				returnObj = petList;
			} else {
				returnObj = "Sorry! Pet doesn't exist with id "+userId;
			}
		} catch (Exception e) {
			returnObj = "Went Somthing wrong.";
			e.printStackTrace();
		}
		return returnObj;
	}

	@Override
	public Object petDetail(long petId) {
		
		Object returnObj = null;
		Pet petDetail = null;
		try {
			petDetail = petRepository.getOne(petId);
			if(petDetail != null) {
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

}
