package amazonNotificationLLD.entitites;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import amazonNotificationLLD.strategies.EmailStrategy;
import amazonNotificationLLD.strategies.NotificationStrategy;
import amazonNotificationLLD.strategies.PriorityStrategy;
import amazonNotificationLLD.strategies.PushStrategy;
import amazonNotificationLLD.strategies.SMSStrategy;

public class StrategyFactory {
	
	private static final Map<Channel, NotificationStrategy> channelMap = new HashMap<>();
	private static final NotificationStrategy priorityStrategy;
	
	static {
		channelMap.put(Channel.SMS, new SMSStrategy());
		channelMap.put(Channel.EMAIL, new EmailStrategy());
		channelMap.put(Channel.PUSH, new PushStrategy());
		
		 priorityStrategy = new PriorityStrategy(new ArrayList<>(channelMap.values()));
	}

	 public static NotificationStrategy getStrategy(NotificationPriority priority, Channel channel) {
		 
		 if(priority.equals(NotificationPriority.URGENT)) {
			 return priorityStrategy;
		 }
		 else {
			 return channelMap.getOrDefault(channel, null);
		 }
	 }
}
