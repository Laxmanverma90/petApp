package com.hcl.pets.repository;

import java.util.List;

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
}
