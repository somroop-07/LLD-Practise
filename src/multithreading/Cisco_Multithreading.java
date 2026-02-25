package multithreading;

class NumberPrinter {
	
	private static int number = 1;
	private static int n;
	
	public NumberPrinter(int n) {
		this.n= n;
	}
	public synchronized void printOdd() throws InterruptedException {
		while(number <= n) {
			while(number % 2 == 0) {
				wait();
			}
			if(number <= n) {
			System.out.println(Thread.currentThread().getName() + " -> " + number);
			number++;
			notifyAll();
			}
		}
	}
	public synchronized void printEven() throws InterruptedException {
		while(number <= n) {
			while(number % 2 != 0) {
				wait();
			}
			if(number <= n) {
			System.out.println(Thread.currentThread().getName() + " -> " + number);
			number++;
			notifyAll();
			}
		}
	}
}

//problem Statement: Build 2 threads;
//Print numbers from 1 to N;
//Odd numbers are printed from thread 1 and even numbers printed from thread 2
public class Cisco_Multithreading {
   public static void main(String[] args) {
	
	   NumberPrinter printer = new NumberPrinter(10);
	   
	   Thread t1 = new Thread(() -> {
		   try {
			   printer.printOdd();
		   }
		   catch (InterruptedException e) {
			e.printStackTrace();
		}
	   }, "Thread 1");

       Thread t2 = new Thread(() -> {
		   try {
			printer.printEven();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	   }, "Thread 2");
       t1.start();
       t2.start();
}
}
