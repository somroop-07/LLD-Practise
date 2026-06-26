package amazonNotificationLLD;

import amazonNotificationLLD.entitites.Channel;
import amazonNotificationLLD.entitites.Notification;
import amazonNotificationLLD.entitites.NotificationPriority;
import amazonNotificationLLD.entitites.User;
import amazonNotificationLLD.service.NotificationService;

public class NotificationDriver {

	public static void main(String[] args) {
		  User user1 = new User("u1", "Akash", Channel.EMAIL);
		  
		  NotificationService notificationService = new NotificationService();
		  
		  Notification notification1 = new Notification("otp-1234", NotificationPriority.URGENT);
		  Notification notification2 = new Notification("SALE IS LIVE", NotificationPriority.NORMAL);
		  
		  notificationService.sendNotification(user1, notification2);
		  notificationService.sendNotification(user1, notification1);
	}
}
