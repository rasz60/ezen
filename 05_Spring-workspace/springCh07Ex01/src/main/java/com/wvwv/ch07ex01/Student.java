package com.wvwv.ch07ex01;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

								// bean ���� ��, �Ҹ� �� ȣ���ϴ� �޼��带 ���� �������̽�
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

	// bean ������ �� ȣ��Ǵ� �޼���
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("implements afterPropertieSet().");
	}
	
	// bean �Ҹ�� ȣ��Ǵ� �޼���
	@Override
	public void destroy() throws Exception {
		System.out.println("implements destory().");
	}

	
}
