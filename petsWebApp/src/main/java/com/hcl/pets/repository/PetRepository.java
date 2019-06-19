package com.hcl.pets.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.pets.model.Pet;

/**
 * @author laxman verma
 *
 */
@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

	@Query("from Pet p where petOwnerId = :userId")
	public List<Pet> findByUserId(String userId);
	
	
	@Query("from Pet p where p.petName= :petName  and p.petAge= :petAge and p.petPlace= :petPlace")
	public Optional<Pet> findPetByNameByAgeByPlace(String petName, int petAge, String petPlace);
}
