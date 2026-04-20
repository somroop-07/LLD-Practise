package LLD_Problems.MultilevelparkingSpot.ParkingSpot;

import LLD_Problems.MultilevelparkingSpot.Floor;
import LLD_Problems.MultilevelparkingSpot.Vehicle.VehicleType;

public class FourWheelerParkingSpot extends ParkingSpot{

	public FourWheelerParkingSpot(Floor floor) {
		super(20, VehicleType.FOUR_WHEELER, floor);
	}

}
