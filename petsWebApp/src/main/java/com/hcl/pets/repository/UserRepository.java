package com.hcl.pets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hcl.pets.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("from User u where userName= :userName")
	public User findUserByName(String userName);

}
