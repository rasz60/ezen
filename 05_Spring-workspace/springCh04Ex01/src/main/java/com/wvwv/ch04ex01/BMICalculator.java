package com.wvwv.ch04ex01;

public class BMICalculator {
	private int obesity;
	private int overWeight;
	private int normal;
	
	
	public void setObesity(int obesity) {
		this.obesity = obesity;
	}

	public void setOverWeight(int overWeight) {
		this.overWeight = overWeight;
	}

	public void setNormal(int normal) {
		this.normal = normal;
	}


	public void bmiCalculation(double weight, double height) {
		double h = height * 0.01;
		double result = weight / (h*h);
		System.out.print("BMI ���� " + (int)result + "(��)�� ");
		if (result > obesity) {
			System.out.print("���Դϴ�.");
		} else if (result > overWeight) {
			System.out.print("��ü���Դϴ�.");			
		} else if (result > normal) {
			System.out.print("�����Դϴ�.");
		} else {
			System.out.print("��ü���Դϴ�.");
		}
		System.out.println("(ǥ��ġ : " + normal + " ~ " + overWeight + ")");
	}
}
