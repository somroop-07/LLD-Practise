package MeetingScheduler.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MeetingScheduler {
   MeetingRoomManager meetingRoomManager;
   List<MeetingRoomObservers> observerList;

  
   
   public MeetingScheduler(MeetingRoomManager meetingRoomManager) {
	super();
	this.meetingRoomManager = meetingRoomManager;
	this.observerList = new ArrayList<>();
}

   public Meeting createMeeting(LocalDate date, TimeSlot slot, int capacity, List<User> users) {
	   try {
		MeetingRoom room = meetingRoomManager.bookMeetingRoom(capacity, date, slot);
		Meeting meeting = new Meeting(date, slot, users, capacity, room);
		updateObservers(meeting);
		return meeting;
	   } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	   }
	   return null;
   }

   private void updateObservers(Meeting meeting) {
	for(MeetingRoomObservers meetingRoomObservers : observerList) {
		meetingRoomObservers.update(meeting);
	}
	
   }
   public void addObserver(MeetingRoomObservers observer) {
	   observerList.add(observer);
   }
}
