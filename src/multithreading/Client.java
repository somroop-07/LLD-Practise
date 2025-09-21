package multithreading;

class MyThread extends Thread {
	public void run() {
		for(int i = 0; i < 10; i++)
		System.out.println("My Thread runnning... " + i);
	}
}
class MyRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("My Runnnable runnning... ");	
	}
}
public class Client {
	public static void main(String[] args) {
		//1st way
		MyThread thread1 = new MyThread();
		MyThread thread2 = new MyThread();
		thread1.start();
		thread2.start();
		
		//2nd way
		Thread thread3 = new Thread(new MyRunnable());
		thread3.start();
		
		//3rd way
		Thread thread4 = new Thread(()-> {
			System.out.println("My Thread4 runnning... ");	
		});
		thread4.start();
		
	}

}
