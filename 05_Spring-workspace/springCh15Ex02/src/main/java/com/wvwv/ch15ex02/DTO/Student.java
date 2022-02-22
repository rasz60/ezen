package com.wvwv.ch15ex02.DTO;

public class Student {
	private String name;
	private String id;
	
	public Student() {
		super();
		System.out.println("Student.defaultConstructor()");
	}
	
	public String getName() {
		System.out.println("Student.getName()");
		return name;
	}
	
	public void setName(String name) {
		System.out.println("Student.setName()");
		this.name = name;
	}
	
	public String getId() {
		System.out.println("Student.getId()");
		return id;
	}
	
	public void setId(String id) {
		System.out.println("Student.setId()");
		this.id = id;
	}
	
}
