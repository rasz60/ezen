package com.wvwv.ch07ex01;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

								// bean 생성 시, 소멸 시 호출하는 메서드를 가진 인터페이스
public class Student implements InitializingBean, DisposableBean {
	private String name;
	private int age;
	
	public Student() {}

	public Student(String name, int age) {
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
		return "Student [" + name + "] : [age=" + age + "]";
	}

	// bean 생성한 후 호출되는 메서드
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("implements afterPropertieSet().");
	}
	
	// bean 소멸시 호출되는 메서드
	@Override
	public void destroy() throws Exception {
		System.out.println("implements destory().");
	}

	
}
