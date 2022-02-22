package com.wvwv.ch04ex01;

import java.util.ArrayList;

public class MyInfo {
	private String name;
	private double height;
	private double weight;
	private ArrayList<String> hobbys;
	private BMICalculator bmiCalc;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public void setHobbys(ArrayList<String> hobbys) {
		this.hobbys = hobbys;
	}
	
	public void setBmiCalc(BMICalculator bmiCalc) {
		this.bmiCalc = bmiCalc;
	}

	public void getInfo() {
		System.out.println();
		System.out.println("MyInfo =============================================================="
						 + "\n¿Ã∏ß : " + name + "\nheight=" + height + "\nweight=" + weight + "\nhobbys=" + hobbys);
		System.out.println();
		bmiCalc();
		System.out.println("=====================================================================");
		System.out.println();
	}
	public void bmiCalc() {
		bmiCalc.bmiCalculation(weight, height);
	}
}
