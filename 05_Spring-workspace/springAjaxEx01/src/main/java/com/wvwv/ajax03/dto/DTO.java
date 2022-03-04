package com.wvwv.ajax03.dto;

public class DTO {
	private String name;
	private int age;
	
	public DTO() {
		super();
	}

	public DTO(String name, int age) {
		super();
		this.name = name;
		this.age = age;
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
	
}
