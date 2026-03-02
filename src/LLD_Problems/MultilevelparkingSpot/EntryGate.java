package LLD_Problems.MultilevelparkingSpot;

import LLD_Problems.MultilevelparkingSpot.ParkingSpot.ParkingSpot;
import LLD_Problems.MultilevelparkingSpot.Vehicle.Vehicle;

public class EntryGate {
    
	private ParkingLot parkingLot;
	
	
	public EntryGate(ParkingLot parkingLot) {
		this.parkingLot = parkingLot;
	}


	public Ticket generateTicket(Vehicle vehicle) {
		ParkingSpot spot = parkingLot.bookParkingSpot(vehicle);
		System.out.println("Floor to park - > " + spot.getFloor().getFloorNumber());
		System.out.println("parking ID to park - > " + spot.getId());
		Ticket ticket = new Ticket(vehicle, spot);
		return ticket;
	}
}
