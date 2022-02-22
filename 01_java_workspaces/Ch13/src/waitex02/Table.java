package waitex02;
import java.util.ArrayList;

public class Table {
	String[] dishNames = { "donut", "donut", "burger" };
	final int MAX_FOOD = 6;
	
	private ArrayList<String> dishes = new ArrayList<>();

	public synchronized void add(String dish) {						// table이 dishes.add()를 수행하는 중에 접근하지 못하도록 synchronized 선언
		if ( dishes.size() >= MAX_FOOD ) {
			return;
		} 
		dishes.add(dish);
		System.out.println("Dishes : " + dishes.toString());
	}

	public boolean remove(String dishName) {
		synchronized(this) {										// customer.eatFood()에서 remove()를 호출해서 수행하는 중에 접근하지 못하도록 synchronized 선언
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
