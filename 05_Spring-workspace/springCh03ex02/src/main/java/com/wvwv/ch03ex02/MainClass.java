package com.wvwv.ch03ex02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {

		// Spring IOC 방식
		
		// bean을 정의한 xml 위치
		String configLocation = "classpath:applicationCTX.xml";
		
		// 지정한 xml 파일의 값을 로드시킨다.
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		
		// getBean("id" , class) : 위에서 로드한 xml에서 "id"에 해당하는 bean 객체를 해당 클래스 객체로 대입
		MyCalculator myCalc = ctx.getBean("myCalculator", MyCalculator.class);
		
		myCalc.add();
		
	/*
		//기존 java 방식
		MyCalculator myCalc = new MyCalculator();
		myCalc.setCalc(new Calculator());
		myCalc.setFirstNum(10);
		myCalc.setSecondNum(2);
		
		myCalc.add();
		
	*/
	}

}
