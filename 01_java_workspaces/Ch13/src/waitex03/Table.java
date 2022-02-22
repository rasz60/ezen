package waitex03;
import java.util.ArrayList;

public class Table {
	String[] dishNames = { "donut", "donut", "burger" };
	final int MAX_FOOD = 6;
	
	private ArrayList<String> dishes = new ArrayList<>();

	public synchronized void add(String dish) {
		while(dishes.size() >= MAX_FOOD ) {
			String name = Thread.currentThread().getName();
			System.out.println(name + " is waiting.");					
			
			try {
				wait();												// dishes size만큼 음식이 생성되면 cook은 wait().
				Thread.sleep(500);			
			} catch(InterruptedException e) {}
		}
		
		dishes.add(dish);
		notify();													// dishes에 음식 추가가 완료되면 notify(). (wait()하고 있는 thread를 깨움)
		System.out.print("Dishes : " + dishes.toString());
		
	}

	public void remove(String dishName) {
		synchronized(this) {
			String name = Thread.currentThread().getName();			
			
			while( dishes.size() == 0 ) {
				System.out.println(name + " is waiting.");
				try {
					wait();											// dishes size가 0이면 (음식이 없으면), customer는 wait().
					Thread.sleep(500);
				} catch(InterruptedException e) {}
			}
			
			while(true) {
				for( int i = 0; i < dishes.size(); i++ ) {
					if ( dishName.equals(dishes.get(i)) ) {			// customer가 먹고 싶은 음식이 dishes에 있으면 가져가고, dishes에 해당 음식을 지운 다음 notify().
						dishes.remove(i);
						notify();
						return;
					}
				}
				
				try {												// customer가 먹고 싶은 음식이 dishes에 없으면 wait().
					System.out.println(name + " is waiting.");
					wait();
					Thread.sleep(500);
				} catch (InterruptedException e) {}
			}
		}
	}
	
	public int dishNum() {
		return dishNames.length;
	}

}
