package LLD_Problems.MultilevelparkingSpot;

import java.time.LocalDateTime;

import LLD_Problems.MultilevelparkingSpot.ParkingSpot.ParkingSpot;
import LLD_Problems.MultilevelparkingSpot.Vehicle.Vehicle;


public class Ticket {
	private static int global_id = 1;
     private int id;
     private LocalDateTime startTime;
     Vehicle vehicle;
     ParkingSpot spot;
     Floor floor;
     
     public Ticket(Vehicle vehicle, ParkingSpot spot) {
		this.id = global_id ++;
		this.startTime = LocalDateTime.now();
		this.vehicle = vehicle;
		this.spot = spot;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public ParkingSpot getSpot() {
		return spot;
	}

	public void setSpot(ParkingSpot spot) {
		this.spot = spot;
	}
     
}
