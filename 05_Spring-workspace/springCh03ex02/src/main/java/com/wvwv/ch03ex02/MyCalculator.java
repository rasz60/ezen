package com.wvwv.ch03ex02;

// IOC �����̳ʿ��� bean�� ������ Ŭ������, �����ڿ� setter �޼��� �ʿ�.
public class MyCalculator {
	// �ܺ� Ŭ���� ��ü�� ������ ���
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
		// �ܺ� Ŭ���� ������ �̿��� �ܺ� �޼��带 ���
		calc.addition(firstNum, secondNum);
	}
}
