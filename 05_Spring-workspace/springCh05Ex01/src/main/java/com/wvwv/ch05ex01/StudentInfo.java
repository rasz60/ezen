package com.wvwv.ch05ex01;

public class StudentInfo {
	// Student ���������� ���� �۾��� �����ϴ� ������ Ŭ����
	private Student student;

	public StudentInfo() {}

	public StudentInfo(Student student) {
		this.student = student;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	public void getStudentInfo() {
		if ( student != null ) {
			System.out.println(
								"�̸� : " + student.getName() + 
								"\n���� : " + student.getAge() + 
								"\n�г� : " + student.getGradeNum() + 
								"\n��  : " + student.getClassNum() + 
								"\n================================" 
							  );
		}
	}
	
}
