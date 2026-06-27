package amazonNotificationLLD.service;

import amazonNotificationLLD.entitites.Notification;
import amazonNotificationLLD.entitites.StrategyFactory;
import amazonNotificationLLD.entitites.User;
import amazonNotificationLLD.strategies.NotificationStrategy;

public class NotificationService {
    
	public void sendNotification(User user, Notification notification) {
		//Factory here acts as a router. Needs to know business logic of notification priority handling, user preference handling, etc.
		NotificationStrategy strategy = StrategyFactory.getStrategy(notification.getPriority(), user.getPreferredChannel());
		strategy.sendNotification(notification, user);
		
		//Alternate Design. More extensible. Future if more combinations of channels added.
		//Have a Notification Router class to handle business logic
		
		//List<Channels> channelList = notificationRouter.getChannels(notification, user);
		//for(Channel channel : channelList) {
		//    NotificationStrategy strategy = StrategyFactory.getStrategy(channel);
		//    strategy.sendNotification(notification, user);
		//}
		
		//Factory only sends strategy against channel. No business logic handling.
		//No more need of PriorityStrategy
		//If future more combinations, no need to create more composite strategies. Just change Notification Router class.


	}
	
	
}
