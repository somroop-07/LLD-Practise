package amazonNotificationLLD.Dispatcher;

import amazonNotificationLLD.entitites.NotificationTask;

public class SMSDispatcher extends Dispatcher{
	
	

	@Override
	public void executeTask(NotificationTask notificationTask) {
		
		System.out.println("SMS vendor");
	}

}
