package amazonNotificationLLD.strategies;

import amazonNotificationLLD.entitites.Notification;
import amazonNotificationLLD.entitites.User;

public interface NotificationStrategy {

	public void sendNotification(Notification notification, User user);
}

