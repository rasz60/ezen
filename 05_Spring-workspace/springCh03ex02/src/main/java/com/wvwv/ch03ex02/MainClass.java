package com.wvwv.ch03ex02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {

		// Spring IOC ���
		
		// bean�� ������ xml ��ġ
		String configLocation = "classpath:applicationCTX.xml";
		
		// ������ xml ������ ���� �ε��Ų��.
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		
		// getBean("id" , class) : ������ �ε��� xml���� "id"�� �ش��ϴ� bean ��ü�� �ش� Ŭ���� ��ü�� ����
		MyCalculator myCalc = ctx.getBean("myCalculator", MyCalculator.class);
		
		myCalc.add();
		
	/*
		//���� java ���
		MyCalculator myCalc = new MyCalculator();
		myCalc.setCalc(new Calculator());
		myCalc.setFirstNum(10);
		myCalc.setSecondNum(2);
		
		myCalc.add();
		
	*/
	}

}
