package com.wvwv.ch16_ex01;

public class People {

	private String name;
	private String id;
	private String address;
	private int age;
		
	public People() {
		super();
	}

	public People(String name, String id, String address, int age) {
		super();
		this.name = name;
		this.id = id;
		this.address = address;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
