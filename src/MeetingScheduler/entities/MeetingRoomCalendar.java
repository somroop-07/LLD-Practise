package MeetingScheduler.entities;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class MeetingRoomCalendar {
    Map<LocalDate, TreeSet<TimeSlot>> meetingListMap;
     
    public MeetingRoomCalendar() {
		super();
		this.meetingListMap = new HashMap<>();
	}
    
    private boolean checkAvailability(LocalDate date, TimeSlot timeSlot) {
    	if(!meetingListMap.containsKey(date)) {
    		return true;
    	}
//    	for(TimeSlot bookedtimeSlot : meetingListMap.get(date)) {
//    		if(timeSlot.overlaps(bookedtimeSlot)) {
//    			return false;
//    		}
//    	}
    	
    	//Only neighbouring intervals can overlap
    	
    	TreeSet<TimeSlot> meetingsDate = meetingListMap.get(date);
    	TimeSlot floorTimeSlot = meetingsDate.floor(timeSlot);
    	if(floorTimeSlot != null && floorTimeSlot.overlaps(timeSlot)) {
    		return false;
    	}
    	TimeSlot ceilTimeSlot = meetingsDate.ceiling(timeSlot);
    	if(ceilTimeSlot != null && ceilTimeSlot.overlaps(timeSlot)) {
    		return false;
    	}
    	return true;
    }

	public synchronized boolean addMeeting(LocalDate date, TimeSlot timeSlot) {
    	  
		if(checkAvailability(date, timeSlot)) {
		meetingListMap.putIfAbsent(date, new TreeSet<>());
		meetingListMap.get(date).add(timeSlot);
		return true;
		}
		else {
			return false;
		}
		
    }
    
}
