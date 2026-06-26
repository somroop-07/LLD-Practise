package amazonNotificationLLD.strategies;

import java.util.List;

import amazonNotificationLLD.entitites.Notification;
import amazonNotificationLLD.entitites.User;

public class PriorityStrategy implements NotificationStrategy{

	List<NotificationStrategy> strategyList;
	
	
	public PriorityStrategy(List<NotificationStrategy> stratgeyList) {
		super();
		this.strategyList = stratgeyList;
	}


	@Override
	public void sendNotification(Notification notification, User user) {
		for(NotificationStrategy strategy : strategyList) {
			strategy.sendNotification(notification, user);
		}
	}

}
