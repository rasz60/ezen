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
		lock.lock();																// add�� �����ϸ� �ٸ� ��ü�� �������� ���ϵ��� lock().
		try {
			while(dishes.size() >= MAX_FOOD ) {
				String name = Thread.currentThread().getName();
				System.out.println(name + " is waiting.");					
				
				try {
					forCook.await();												// dishes size��ŭ ������ �����Ǹ� cook�� forCook���� await().
					Thread.sleep(500);			
				} catch(InterruptedException e) {}
			}
		
			dishes.add(dish);
			forCust.signal();														// dishes size��ŭ ������ �����Ǹ� forCust�� await()���� thread singnal().
			System.out.print("Dishes : " + dishes.toString());						
		} finally {
			lock.unlock();															// �۾��� ������ �ٸ� ��ü�� ������ �� �ֵ��� unlock().
		}
	}

	public void remove(String dishName) {
		lock.lock();
		String name = Thread.currentThread().getName();			

		try {
			while( dishes.size() == 0 ) {
				System.out.println(name + " is waiting.");
				try {
					forCust.await();												// dishes size�� 0�̸� (������ ������), customer�� forCust���� await().
					Thread.sleep(500);
				} catch(InterruptedException e) {}
			}
			
			while(true) {
				for( int i = 0; i < dishes.size(); i++ ) {
					if ( dishName.equals(dishes.get(i)) ) {							// customer�� �԰� ���� ������ dishes�� ������ ��������, dishes�� �ش� ������ ���� ���� forCook�� �ִ� cook���� signal().
						dishes.remove(i);
						forCook.signal();
						return;
					}
				}
				
				try {																// customer�� �԰� ���� ������ dishes�� ������ forCust���� await().
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
