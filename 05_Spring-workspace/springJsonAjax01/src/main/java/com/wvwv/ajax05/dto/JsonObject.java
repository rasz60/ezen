package com.wvwv.ajax05.dto;

public class JsonObject {
	private String name;
	private int age;
	public JsonObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JsonObject(String name, int age) {
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
