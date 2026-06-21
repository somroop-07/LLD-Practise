package MeetingScheduler.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Meeting {
	 String id;
     LocalDate date;
     TimeSlot timeSlot;
     List<User> users;
     int capacity;
     MeetingRoom room;
     RecurrenceRule recurrenceRule;
     
	 public Meeting(LocalDate date, TimeSlot timeSlot, List<User> users, int capacity, MeetingRoom room, RecurrenceRule recurrenceRule) {
		super();
		this.id = UUID.randomUUID().toString();
		this.date = date;
		this.timeSlot = timeSlot;
		this.users = users;
		this.capacity = capacity;
		this.room = room;
		this.recurrenceRule = recurrenceRule;
	 }
	 public MeetingRoom getRoom() {
		return room;
	}
	public void setRoom(MeetingRoom room) {
		this.room = room;
	}
	 public String getId() {
		 return id;
	 }
	 public void setId(String id) {
		 this.id = id;
	 }
	 public LocalDate getDate() {
		 return date;
	 }
	 public void setDate(LocalDate date) {
		 this.date = date;
	 }
	 public TimeSlot getTimeSlot() {
		 return timeSlot;
	 }
	 public void setTimeSlot(TimeSlot timeSlot) {
		 this.timeSlot = timeSlot;
	 }
	 public List<User> getUsers() {
		 return users;
	 }
	 public void setUsers(List<User> users) {
		 this.users = users;
	 }
	 public int getCapacity() {
		 return capacity;
	 }
	 public void setCapacity(int capacity) {
		 this.capacity = capacity;
	 }
     
     
}
