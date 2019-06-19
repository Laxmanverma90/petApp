package com.hcl.pets.bean;

public class PetBean {

	private long id;
	
	private String petName;
	
	private int petAge;
	
	private String petPlace;
	
	private long petOwnerId;

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

	public long getPetOwnerId() {
		return petOwnerId;
	}

	public void setPetOwnerId(long petOwnerId) {
		this.petOwnerId = petOwnerId;
	}

	@Override
	public String toString() {
		return "PetBean [id=" + id + ", petName=" + petName + ", petAge=" + petAge + ", petPlace=" + petPlace
				+ ", petOwnerId=" + petOwnerId + "]";
	}

	public PetBean(long id, String petName, int petAge, String petPlace, long petOwnerId) {
		super();
		this.id = id;
		this.petName = petName;
		this.petAge = petAge;
		this.petPlace = petPlace;
		this.petOwnerId = petOwnerId;
	}

	public PetBean() {
		super();
		// TODO Auto-generated constructor stub
	}
}
