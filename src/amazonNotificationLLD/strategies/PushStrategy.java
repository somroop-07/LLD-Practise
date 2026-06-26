package amazonNotificationLLD.strategies;

import amazonNotificationLLD.entitites.Notification;
import amazonNotificationLLD.entitites.User;

public class PushStrategy implements NotificationStrategy{

	@Override
	public void sendNotification(Notification notification, User user) {
		//Push dispatcher class will have blocking queue and start pool of worker threads
		//Push into Push blocking queue
		//Push worker threads will pick up and execute using 3rd party services
		System.out.println("Sending Notification " + notification.getContent() + " through push" );		
		
	}

}
