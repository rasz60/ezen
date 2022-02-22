package com.wvwv.ch07ex01;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class OtherStudent {
	private String name;
	private int age;
	
	public OtherStudent() {}

	public OtherStudent(String name, int age) {
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

	@Override
	public String toString() {
		return "OtherStudent [" + name + "] : [age=" + age + "]";
	}
	
	@PostConstruct
	public void afterPropertiesSet() throws Exception {
		System.out.println("annotation afterPropertieSet().");
	}

	@PreDestroy
	public void destroy() throws Exception {
		System.out.println("annotation destory().");
	}

}
