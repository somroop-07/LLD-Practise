package multithreading;

import java.util.LinkedList;
import java.util.Queue;

class PublisherConsumerService {
	private final int bufferSize = 5;
	private Queue<Integer> queue = new LinkedList<>();
	private Object lock = new Object();
    
	public void publish(int x) throws InterruptedException {
		synchronized (lock) {
			while(queue.size() == bufferSize) {
				System.out.println("Queue full; Cannot add");
				lock.wait();
			}
			queue.add(x);
			System.out.println("Added value: " + x);
			lock.notifyAll();
		}
	}
	public void consume() throws InterruptedException {
		synchronized (lock) {
			while(queue.isEmpty()) {
				System.out.println("Queue empty; Nothing to consume");
				lock.wait();
			}
			int x = queue.remove();
			System.out.println("Consumed value: " + x);
		}
	}
	
	
}
public class PublisherConsumer {
  public static void main(String[] args) {
	  PublisherConsumerService service = new PublisherConsumerService();
	  Thread producerThread = new Thread(() -> {
			 try {
				service.publish(11);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 });
	 Thread consumerThread = new Thread(() -> {
		 try {
				service.consume();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 });
	 producerThread.start();
	 consumerThread.start();
}
}
