package MeetingScheduler;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

import MeetingScheduler.entities.Meeting;
import MeetingScheduler.entities.MeetingRoom;
import MeetingScheduler.entities.MeetingRoomManager;
import MeetingScheduler.entities.MeetingRoomObservers;
import MeetingScheduler.entities.MeetingScheduler;
import MeetingScheduler.entities.NotificationService;
import MeetingScheduler.entities.TimeSlot;
import MeetingScheduler.entities.User;
//Requirements:
//1) N meeting rooms with different capacities
//2) Book meeting room with startTime and endTime
//3) Send notifications to all users invited to the meeting
//4) Use Meeting Room Calendar to track all meetings date and time
public class Driver {
    public static void main(String[] args) {
    	MeetingRoom meetingRoom1 = new MeetingRoom("m1", 3);
    	MeetingRoom meetingRoom2 = new MeetingRoom("m2", 7);
    	MeetingRoom meetingRoom3 = new MeetingRoom("m3", 10);
    	MeetingRoom meetingRoom4 = new MeetingRoom("m4", 2);
    	MeetingRoom meetingRoom5 = new MeetingRoom("m5", 6);
    	
    	MeetingRoomManager meetingRoomManager = new MeetingRoomManager();
    	meetingRoomManager.addMeetingRoom(meetingRoom1);
    	meetingRoomManager.addMeetingRoom(meetingRoom2);
    	meetingRoomManager.addMeetingRoom(meetingRoom3);
    	meetingRoomManager.addMeetingRoom(meetingRoom4);
    	meetingRoomManager.addMeetingRoom(meetingRoom5);
    	
    	MeetingRoomObservers notificationService = new NotificationService();
    	
    	MeetingScheduler scheduler = new MeetingScheduler(meetingRoomManager);
    	scheduler.addObserver(notificationService);
    	
    	User user1 = new User("abc.gmail.com");
    	User user2 = new User("gdl.gmail.com");
    	User user3 = new User("dsf.gmail.com");
    	User user4 = new User("ggd.gmail.com");
    	User user5 = new User("xyz.gmail.com");
    	
    	Meeting meeting1 = scheduler.createMeeting(LocalDate.now(), new TimeSlot(LocalTime.of(15, 0), LocalTime.of(16, 0)), 5, Arrays.asList(user1, user2,user3, user4, user5));
    	Meeting meeting2 = scheduler.createMeeting(LocalDate.now(), new TimeSlot(LocalTime.of(15, 0), LocalTime.of(16, 0)), 3, Arrays.asList(user1, user2,user3));
	}
	
  
	
}
