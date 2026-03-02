package LLD_Problems.MultilevelparkingSpot.ParkingSpot;

import LLD_Problems.MultilevelparkingSpot.Floor;
import LLD_Problems.MultilevelparkingSpot.Vehicle.VehicleType;

public class TwoWheelerParkingSpot extends ParkingSpot{

	public TwoWheelerParkingSpot(Floor floor) {
		super(10, VehicleType.TWO_WHEELER, floor);
	}

}
