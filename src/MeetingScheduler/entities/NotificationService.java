package MeetingScheduler.entities;

public class NotificationService implements MeetingRoomObservers {

	@Override
	public void update(Meeting meeting) {
		for(User user: meeting.getUsers()) {
			System.out.println("Sending email to : " + user.getEmail() + " MeetingScheduled at : " + meeting.getDate() + " at " + meeting.getRoom().getId());
		}
		
	}

}
