package MeetingScheduler.entities;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Set;

public class RecurrenceRule {

	RecurrenceType recurrenceType;
	LocalDate endDate;
	Set<DayOfWeek> daysOfWeeks;
	public RecurrenceRule(RecurrenceType recurrenceType, LocalDate endDate, Set<DayOfWeek> daysOfWeeks) {
		super();
		this.recurrenceType = recurrenceType;
		this.endDate = endDate;
		this.daysOfWeeks = daysOfWeeks;
	}
	public RecurrenceType getRecurrenceType() {
		return recurrenceType;
	}
	public void setRecurrenceType(RecurrenceType recurrenceType) {
		this.recurrenceType = recurrenceType;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public Set<DayOfWeek> getDaysOfWeeks() {
		return daysOfWeeks;
	}
	public void setDaysOfWeeks(Set<DayOfWeek> daysOfWeeks) {
		this.daysOfWeeks = daysOfWeeks;
	}
	
	
}
