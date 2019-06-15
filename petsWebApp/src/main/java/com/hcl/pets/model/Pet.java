package com.hcl.pets.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Laxman verma
 *
 */
@Entity
@Table(name = "PETS")
public class Pet implements Serializable {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "PET_NAME")
	private String petName;
	
	@Column(name = "PET_AGE")
	private int petAge;
	
	@Column(name = "PET_PLACE")
	private String petPlace;
	
	@Column(name = "PET_OWNERID")
	private String petOwnerId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public int getPetAge() {
		return petAge;
	}

	public void setPetAge(int petAge) {
		this.petAge = petAge;
	}

	public String getPetPlace() {
		return petPlace;
	}

	public void setPetPlace(String petPlace) {
		this.petPlace = petPlace;
	}



	public String getPetOwnerId() {
		return petOwnerId;
	}

	public void setPetOwnerId(String petOwnerId) {
		this.petOwnerId = petOwnerId;
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", petName=" + petName + ", petAge=" + petAge + ", petPlace=" + petPlace
				+ ", petOwnerId=" + petOwnerId + "]";
	}
}