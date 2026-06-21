package MeetingScheduler.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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

	public synchronized boolean addMeeting(LocalDate date, TimeSlot timeSlot, RecurrenceRule recurrenceRule) {
    	
		List<LocalDate> allMeetings = generateAllMeetings(date, recurrenceRule);
		for(LocalDate allDates : allMeetings) {
			if(!checkAvailability(allDates, timeSlot)) {
				return false;
			}
		}
		for(LocalDate allDates : allMeetings) {
			meetingListMap.putIfAbsent(allDates, new TreeSet<>());
			meetingListMap.get(allDates).add(timeSlot);
		}
		
		return true;
		
    }
	
	public List<LocalDate> generateAllMeetings(LocalDate date, RecurrenceRule recurrenceRule) {
		if(recurrenceRule == null){
			return Arrays.asList(date);
		}
		LocalDate currDate = date;
		List<LocalDate> list = new ArrayList<>();
		
		//Instead of using switch statements, if time permits, use strategy design pattern
		//Create a RecurrenceStrategy interface and concrete strategies like WeeklyStrategy, etc
		//Strategy will have a method called generateAllMeetings and return list
		//Use StrategyFactory which willl have hashmap of recurrenceType vs Strategy. Returns strategy when passed type
		//Easily extensible to other rules added in future. No change in if-else, Open-close principle.
		
		
		switch(recurrenceRule.getRecurrenceType()) {
		case NONE: 
			list.add(currDate);
			break;
		
		case DAILY : 
			while(!currDate.isAfter(recurrenceRule.getEndDate())) {
					list.add(currDate);
				    currDate = currDate.plusDays(1);
			}
		   break;
		case WEEKLY: 
			while(!currDate.isAfter(recurrenceRule.getEndDate())) {
				if(recurrenceRule.getDaysOfWeeks().contains(currDate.getDayOfWeek())) {
					list.add(currDate);
				}
				currDate = currDate.plusDays(1);
			}
		  break;
		case MONTHLY : 
			while(!currDate.isAfter(recurrenceRule.getEndDate())) {
					list.add(currDate);
				currDate = currDate.plusMonths(1);
			}
		  break;
		
			
			
		}
		
		
		return list;
	}
    
}
