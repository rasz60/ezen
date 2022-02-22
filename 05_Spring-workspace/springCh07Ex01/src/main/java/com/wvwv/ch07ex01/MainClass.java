package com.wvwv.ch07ex01;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		System.out.println("스프링 콘테이너의 생명 주기");
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		System.out.println("GenericXmlApplicationContext 객체로 스프링 컨테이너 생성");
		
		ctx.load("classpath:applicationCTX.xml");
		ctx.refresh();
		// bean 설정과 초기화 완료된 후 해당 클래스의 afterPropertiesSet() 실행
		System.out.println("ctx.load('classpath:~~') : 설정 / ctx.refresh() : 초기화");		
		
		Student student1 = ctx.getBean("student", Student.class);
		OtherStudent student2 = ctx.getBean("otherStudent", OtherStudent.class);
		System.out.println(student1); System.out.println(student2);
		
		System.out.println("ctx.getBean('beanId', className.class) : bean 사용");
		// bean 사용 완료된 후 해당 클래스의 destroy() 실행
		
		ctx.close();
		System.out.println("ctx.close() : 스프링 컨테이너 종료");
	}

}
