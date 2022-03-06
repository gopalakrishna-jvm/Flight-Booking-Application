package com.flight.bookticket.entity;

import javax.persistence.Column;

public class Passenger {

	@Column(nullable = false)
	private String name;
	private int age;
	@Column(nullable = false)
	private Gender gender;
	private boolean veg;

	public Passenger(String name, int age, Gender gender, boolean veg) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.veg = veg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public boolean isVeg() {
		return veg;
	}

	public void setVeg(boolean veg) {
		this.veg = veg;
	}

}
