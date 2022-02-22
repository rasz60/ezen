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
				wait();												// dishes size��ŭ ������ �����Ǹ� cook�� wait().
				Thread.sleep(500);			
			} catch(InterruptedException e) {}
		}
		
		dishes.add(dish);
		notify();													// dishes�� ���� �߰��� �Ϸ�Ǹ� notify(). (wait()�ϰ� �ִ� thread�� ����)
		System.out.print("Dishes : " + dishes.toString());
		
	}

	public void remove(String dishName) {
		synchronized(this) {
			String name = Thread.currentThread().getName();			
			
			while( dishes.size() == 0 ) {
				System.out.println(name + " is waiting.");
				try {
					wait();											// dishes size�� 0�̸� (������ ������), customer�� wait().
					Thread.sleep(500);
				} catch(InterruptedException e) {}
			}
			
			while(true) {
				for( int i = 0; i < dishes.size(); i++ ) {
					if ( dishName.equals(dishes.get(i)) ) {			// customer�� �԰� ���� ������ dishes�� ������ ��������, dishes�� �ش� ������ ���� ���� notify().
						dishes.remove(i);
						notify();
						return;
					}
				}
				
				try {												// customer�� �԰� ���� ������ dishes�� ������ wait().
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
