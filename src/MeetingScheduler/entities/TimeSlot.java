package MeetingScheduler.entities;

import java.time.LocalTime;


public class TimeSlot implements Comparable<TimeSlot> {
    LocalTime startTime;
    LocalTime endTime;
	public TimeSlot(LocalTime startTime, LocalTime endTime) {
		super();
		if(!startTime.isBefore(endTime)) {
			throw new IllegalArgumentException("Invalid time range");
		}
		this.startTime = startTime;
		this.endTime = endTime;
	}
	@Override
	public int compareTo(TimeSlot o) {
		int cmp = this.startTime.compareTo(o.startTime);
		if(cmp == 0) {
			return this.endTime.compareTo(o.endTime);
		}
		return cmp;
	}    
	public boolean overlaps(TimeSlot other) {
		 return this.startTime.isBefore(other.endTime)
			        && this.endTime.isAfter(other.startTime);
	}
    
}
