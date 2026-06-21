package MeetingScheduler.entities;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeSet;



public class MeetingRoomManager {
    TreeSet<MeetingRoom> meetingRoomsList = new TreeSet<>((a, b) -> {
    	int cmp = Integer.compare(a.getCapacity(), b.getCapacity());
    	if(cmp != 0) {
    		return cmp;
    	}
    	return a.getId().compareTo(b.getId());
    });
    

	public MeetingRoomManager() {
		super();
	}
	
	public void addMeetingRoom(MeetingRoom room) {
		meetingRoomsList.add(room);
	}
	
	public MeetingRoom bookMeetingRoom(int capacity, LocalDate date, TimeSlot slot, RecurrenceRule recurrenceRule) throws Exception {
		
		
		for(MeetingRoom room : meetingRoomsList) {
			if(room.book(date, slot, capacity, recurrenceRule)) {
				return room;
			}
		}	
		throw new RuntimeException("No Meeting Rooms available ");
	}
    
}
