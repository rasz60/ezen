package waitex02;
import java.util.ArrayList;

public class Table {
	String[] dishNames = { "donut", "donut", "burger" };
	final int MAX_FOOD = 6;
	
	private ArrayList<String> dishes = new ArrayList<>();

	public synchronized void add(String dish) {						// table�� dishes.add()�� �����ϴ� �߿� �������� ���ϵ��� synchronized ����
		if ( dishes.size() >= MAX_FOOD ) {
			return;
		} 
		dishes.add(dish);
		System.out.println("Dishes : " + dishes.toString());
	}

	public boolean remove(String dishName) {
		synchronized(this) {										// customer.eatFood()���� remove()�� ȣ���ؼ� �����ϴ� �߿� �������� ���ϵ��� synchronized ����
			while( dishes.size() == 0 ) {
				String name = Thread.currentThread().getName();
				System.out.println(name + " is waiting.");
				try {
					Thread.sleep(500);
				} catch(InterruptedException e) {}
			}
			
			for( int i = 0; i < dishes.size(); i++ ) {
				if ( dishName.equals(dishes.get(i)) ) {
					dishes.remove(i);
					return true;
				} 
			}
		}
		return false;
	}
	
	public int dishNum() {
		return dishNames.length;
	}

}
