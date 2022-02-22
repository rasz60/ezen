package com.wvwv.ch05ex01;

public class Student {
	private String name;
	private String age;
	private String gradeNum;
	private String classNum;
	
	public Student() {}
	
	public Student(String name, String age, String gradeNum, String classNum) {
		this.name = name;
		this.age = age;
		this.gradeNum = gradeNum;
		this.classNum = classNum;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public void setGradeNum(String gradeNum) {
		this.gradeNum = gradeNum;
	}

	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}

	public String getName() {
		return name;
	}

	public String getAge() {
		return age;
	}

	public String getGradeNum() {
		return gradeNum;
	}

	public String getClassNum() {
		return classNum;
	}
	
}
