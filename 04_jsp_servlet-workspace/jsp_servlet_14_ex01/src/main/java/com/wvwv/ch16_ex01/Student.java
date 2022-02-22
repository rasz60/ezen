package com.wvwv.ch16_ex01;

//JSP에서 bean으로 사용할 데이터 클래스
public class Student {
	
	// 객체의 속성이 될 변수 선언
	private String name;
	private int age;
	private int grade;
	private int studentNum;

	public Student() {
		super();
	}

	public Student(String name, int age, int grade, int studentNum) {
		super();
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.studentNum = studentNum;
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

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(int studentNum) {
		this.studentNum = studentNum;
	}
	
}
