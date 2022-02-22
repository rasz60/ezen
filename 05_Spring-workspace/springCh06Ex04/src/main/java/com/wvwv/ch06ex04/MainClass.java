package com.wvwv.ch06ex04;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		//Configuration annotation 클래스에서 생성한 bean을 가져오는 클래스
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		Student student1 = ctx.getBean("student1", Student.class);
		student1.setHeight(188);
		student1.setWeight(80);
		Student student2 = ctx.getBean("student2", Student.class);
		
		System.out.println(student1);
		System.out.println(student2);
		
		ctx.close();
	}

}
