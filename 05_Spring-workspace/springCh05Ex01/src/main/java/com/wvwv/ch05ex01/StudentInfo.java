package com.wvwv.ch05ex01;

public class StudentInfo {
	// Student 참조변수를 통해 작업을 수행하는 의존형 클래스
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
								"이름 : " + student.getName() + 
								"\n나이 : " + student.getAge() + 
								"\n학년 : " + student.getGradeNum() + 
								"\n반  : " + student.getClassNum() + 
								"\n================================" 
							  );
		}
	}
	
}
