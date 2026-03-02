package LLD_Problems.MultilevelparkingSpot.Strategies;


import LLD_Problems.MultilevelparkingSpot.Floor;
import LLD_Problems.MultilevelparkingSpot.ParkingLot;
import LLD_Problems.MultilevelparkingSpot.ParkingSpot.ParkingSpot;
import LLD_Problems.MultilevelparkingSpot.Vehicle.Vehicle;

public class RandomStrategy implements ParkingFinderStrategy {
	@Override
	public ParkingSpot findParkingSpot(ParkingLot parkingLot, Vehicle vehicle) {
		
		for(Floor floor : parkingLot.getFloors()) {
			if(floor.getManager().getMp().containsKey(vehicle.getVehicleType())) {
				for(ParkingSpot spot : floor.getManager().getMp().get(vehicle.getVehicleType())) {
					if(spot.isEmpty()) {
						return spot;
					}
				}
			}
		}
		throw new RuntimeException("No spot available");
	}
}
