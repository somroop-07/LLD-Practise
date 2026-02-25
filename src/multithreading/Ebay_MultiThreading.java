package multithreading;

import java.util.jar.Attributes.Name;

class Task extends Thread {
	
	private int time;
	
	Task(String name, int time) {
		super(name);
		this.time = time;
	}
	
	@Override
	public void run() {
		
		try {
			
			Thread.sleep(time * 1000);
			System.out.println(getName() + " finished executing...");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

class Task2 implements Runnable {
	private String name;
	private int time;
	
	Task2(String name, int time) {
		this.name = name;
		this.time = time;
	}

	@Override
	public void run() {
       try {
			
			Thread.sleep(time * 1000);
			System.out.println(name + " finished executing...");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

//Problem Statement ->
//There are three threads assigned different tasks. 
//T1 takes 10 seconds, T2 takes 20 seconds, and T3 takes 15 seconds. 
//How do you ensure that all threads merge into one and continue as a single thread?
//How will you wait for all of them?
public class Ebay_MultiThreading {

	public static void main(String[] args) {
		
//		Thread t1 = new Task("T1", 10);
//		Thread t2 = new Task("T2", 20);
//		Thread t3 = new Task("T3", 15);
		
		Thread t1 = new Thread(new Task2("T1", 10));
		Thread t2 = new Thread(new Task2("T2", 15));
		Thread t3 = new Thread(new Task2("T3", 20));
		
		t1.start();
		t2.start();
		t3.start();
		
		//Main thread waits till t1, t2, t3 finishes execution
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Merges into single thread");
		
	}
}
