package MeetingScheduler.entities;

import java.time.LocalDate;
import java.util.Objects;

public class MeetingRoom {
    String id;
    int capacity;
    MeetingRoomCalendar meetingRoomCalendar;
    
	public MeetingRoom(String id, int capacity) {
		super();
		this.id = id;
		this.capacity = capacity;
		meetingRoomCalendar = new MeetingRoomCalendar();
	}
	@Override
	public boolean equals(Object o) {
	    if(this == o) return true;

	    if(!(o instanceof MeetingRoom)) {
	        return false;
	    }

	    MeetingRoom other =
	            (MeetingRoom) o;

	    return Objects.equals(id, other.id);
	}

	@Override
	public int hashCode() {
	    return Objects.hash(id);
	}
	
	
	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public int getCapacity() {
		return capacity;
	}



	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}



	public MeetingRoomCalendar getMeetingRoomCalendar() {
		return meetingRoomCalendar;
	}



	public void setMeetingRoomCalendar(MeetingRoomCalendar meetingRoomCalendar) {
		this.meetingRoomCalendar = meetingRoomCalendar;
	}
	
	public boolean book(LocalDate date, TimeSlot timeSlot, int capacity, RecurrenceRule recurrenceRule) {
			if(this.capacity < capacity) {
				return false;
			}
			if(meetingRoomCalendar.addMeeting(date, timeSlot, recurrenceRule)) {
				return true;
			}
		 return false;
	}
    
}
