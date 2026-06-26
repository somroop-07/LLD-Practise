package amazonNotificationLLD.entitites;

public class Notification {

	String content;
	NotificationPriority priority;
	
	public Notification(String content, NotificationPriority priority) {
		super();
		this.content = content;
		this.priority = priority;
	}

	public String getContent() {
		return content;
	}

	public NotificationPriority getPriority() {
		return priority;
	}
	
	
}
