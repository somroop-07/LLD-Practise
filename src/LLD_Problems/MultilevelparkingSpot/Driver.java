package LLD_Problems.MultilevelparkingSpot;

import java.time.LocalDateTime;
import java.util.Arrays;

import LLD_Problems.MultilevelparkingSpot.ParkingSpot.FourWheelerParkingSpot;
import LLD_Problems.MultilevelparkingSpot.ParkingSpot.TwoWheelerParkingSpot;
import LLD_Problems.MultilevelparkingSpot.Vehicle.TwoWheeler;
import LLD_Problems.MultilevelparkingSpot.Vehicle.Vehicle;


public class Driver {
    
	public static void main(String[] args) {
		
		ParkingLot parkingLot = ParkingLot.getParkingInstance();
		
		//Can be extensible
		Floor floor1 = parkingLot.addFloor(new Floor(1));
		Floor floor2 = parkingLot.addFloor(new Floor(2));

		floor1.addParkingSpot(Arrays.asList(new FourWheelerParkingSpot(floor1), new FourWheelerParkingSpot(floor1)));
		floor2.addParkingSpot(Arrays.asList(new TwoWheelerParkingSpot(floor2), new FourWheelerParkingSpot(floor2)));
		
		Vehicle vehicle = new TwoWheeler("ABCD1234");
       
		EntryGate entryGate = new EntryGate(parkingLot);
		
		Ticket ticket = entryGate.generateTicket(vehicle);
		ExitGate exitGate = new ExitGate();
		double cost = exitGate.calculateCost(ticket, LocalDateTime.now().plusHours(2));
		System.out.println("Cost -> " + cost);
		
		
		
	}
}
