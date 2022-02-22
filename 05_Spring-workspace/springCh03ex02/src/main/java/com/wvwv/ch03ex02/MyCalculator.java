package com.wvwv.ch03ex02;

// IOC 콘테이너에서 bean을 생성할 클래스로, 생성자와 setter 메서드 필요.
public class MyCalculator {
	// 외부 클래스 객체를 변수로 사용
	Calculator calc;
	
	private int firstNum;
	private int secondNum;
	
	public MyCalculator() {
		super();
	}

	public void setCalc(Calculator calc) {
		this.calc = calc;
	}

	public void setFirstNum(int firstNum) {
		this.firstNum = firstNum;
	}

	public void setSecondNum(int secondNum) {
		this.secondNum = secondNum;
	}
	
	public void add() {
		// 외부 클래스 변수를 이용해 외부 메서드를 사용
		calc.addition(firstNum, secondNum);
	}
}
