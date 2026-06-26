package amazonNotificationLLD.strategies;

import amazonNotificationLLD.entitites.Notification;
import amazonNotificationLLD.entitites.User;

public class EmailStrategy implements NotificationStrategy{

	@Override
	public void sendNotification(Notification notification, User user) {
		//Email dispatcher class will have blocking queue and start pool of worker threads
		//Push into Email blocking queue
		//Email worker threads will pick up and execute using 3rd party services
		System.out.println("Sending Notification " + notification.getContent() + " through email" );		
		
	}

}
