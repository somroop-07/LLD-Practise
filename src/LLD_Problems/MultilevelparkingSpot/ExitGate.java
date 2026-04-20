package LLD_Problems.MultilevelparkingSpot;

import java.time.Duration;
import java.time.LocalDateTime;

public class ExitGate {
 
	public double calculateCost(Ticket ticket, LocalDateTime endTime) {
		//LocalTime endTime = LocalTime.now();
		Duration duration = Duration.between(ticket.getStartTime(), endTime);
		long mins = duration.toMinutes();
		System.out.println(ticket.getStartTime());
		System.out.println(endTime);
		long hours = (mins + 60 - 1) / 60;
		System.out.println(hours);
		ticket.getSpot().freeSpot();
		
		return ticket.getSpot().getPrice() * hours;
	}
}
