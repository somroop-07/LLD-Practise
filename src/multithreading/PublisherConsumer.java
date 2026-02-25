package multithreading;

import java.util.LinkedList;
import java.util.Queue;

class PublisherConsumerService {
	private final int bufferSize = 5;
	private Queue<Integer> queue = new LinkedList<>();
    
	public synchronized void publish(int x) throws InterruptedException {
			while(queue.size() == bufferSize) {
				System.out.println("Queue full; Cannot add");
				wait();
			}
			queue.add(x);
			System.out.println("Added value: " + x);
			notifyAll();
		}
	
	public synchronized void consume() throws InterruptedException {
	
			while(queue.isEmpty()) {
				System.out.println("Queue empty; Nothing to consume");
				wait();
			}
			int x = queue.remove();
			System.out.println("Consumed value: " + x);
			notifyAll();
		}
}

public class PublisherConsumer {
  public static void main(String[] args) {
	  PublisherConsumerService service = new PublisherConsumerService();
	  Thread producerThread = new Thread(() -> {
		  for (int i = 1; i <= 50; i++) {
              try {
                  service.publish(i);
                  Thread.sleep(500);
              } catch (InterruptedException e) {
                  Thread.currentThread().interrupt();
              }
          }
		 });
	 Thread consumerThread = new Thread(() -> {
		 for (int i = 1; i <= 50; i++) {
             try {
                 service.consume();
                 Thread.sleep(1000);
             } catch (InterruptedException e) {
                 Thread.currentThread().interrupt();
             }
         }
	 });
	 producerThread.start();
	 consumerThread.start();
}
}
