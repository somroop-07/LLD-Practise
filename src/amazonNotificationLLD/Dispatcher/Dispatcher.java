package amazonNotificationLLD.Dispatcher;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import amazonNotificationLLD.entitites.Notification;
import amazonNotificationLLD.entitites.NotificationTask;
import amazonNotificationLLD.entitites.User;

public abstract class Dispatcher {

	BlockingQueue<NotificationTask> taskQueue = new ArrayBlockingQueue<>(1000);
	ExecutorService executorService = Executors.newFixedThreadPool(3);

	public Dispatcher() {
		super();
		startWorkers();
	}
	
	public void startWorkers() {
		
		for(int i = 0; i < 3; i++) {
			executorService.submit(() -> {
				
				while(!Thread.currentThread().isInterrupted()) {
					try {
						NotificationTask notificationTask = taskQueue.take();
						executeTask(notificationTask);				
						
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}
					
				}
				
			});
		}
	}
	
	public abstract void executeTask(NotificationTask notificationTask);
	
	public void submitTask(Notification notification, User user) {
		taskQueue.offer(new NotificationTask(notification, user));
	}
	
}
