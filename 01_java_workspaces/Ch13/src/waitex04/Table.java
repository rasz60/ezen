package waitex04;
import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Table {
	String[] dishNames = { "donut", "donut", "burger" };
	final int MAX_FOOD = 6;
	private ArrayList<String> dishes = new ArrayList<>();

	private ReentrantLock lock = new ReentrantLock();
	private Condition forCook  = lock.newCondition();
//	private Condition forCook2 = lock.newCondition();
	private Condition forCust  = lock.newCondition();	
//	private Condition forCust2 = lock.newCondition();
	
	public void add(String dish) {
		lock.lock();																// add에 진입하면 다른 객체가 접근하지 못하도록 lock().
		try {
			while(dishes.size() >= MAX_FOOD ) {
				String name = Thread.currentThread().getName();
				System.out.println(name + " is waiting.");					
				
				try {
					forCook.await();												// dishes size만큼 음식이 생성되면 cook은 forCook에서 await().
					Thread.sleep(500);			
				} catch(InterruptedException e) {}
			}
		
			dishes.add(dish);
			forCust.signal();														// dishes size만큼 음식이 생성되면 forCust에 await()중인 thread singnal().
			System.out.print("Dishes : " + dishes.toString());						
		} finally {
			lock.unlock();															// 작업이 끝나면 다른 객체가 접근할 수 있도록 unlock().
		}
	}

	public void remove(String dishName) {
		lock.lock();
		String name = Thread.currentThread().getName();			

		try {
			while( dishes.size() == 0 ) {
				System.out.println(name + " is waiting.");
				try {
					forCust.await();												// dishes size가 0이면 (음식이 없으면), customer는 forCust에서 await().
					Thread.sleep(500);
				} catch(InterruptedException e) {}
			}
			
			while(true) {
				for( int i = 0; i < dishes.size(); i++ ) {
					if ( dishName.equals(dishes.get(i)) ) {							// customer가 먹고 싶은 음식이 dishes에 있으면 가져가고, dishes에 해당 음식을 지운 다음 forCook에 있는 cook에게 signal().
						dishes.remove(i);
						forCook.signal();
						return;
					}
				}
				
				try {																// customer가 먹고 싶은 음식이 dishes에 없으면 forCust에서 await().
					System.out.println(name + " is waiting.");
					forCust.await();
					Thread.sleep(500);
				} catch (InterruptedException e) {}
			}
		} finally {
			lock.unlock();
		}
	}
	
	public int dishNum() {
		return dishNames.length;
	}

}
