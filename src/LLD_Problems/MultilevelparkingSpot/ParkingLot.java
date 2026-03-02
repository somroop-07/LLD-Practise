package LLD_Problems.MultilevelparkingSpot;

import java.util.ArrayList;
import java.util.List;

import LLD_Problems.MultilevelparkingSpot.ParkingSpot.ParkingSpot;
import LLD_Problems.MultilevelparkingSpot.Strategies.NearestFloorStrategy;
import LLD_Problems.MultilevelparkingSpot.Strategies.ParkingFinderStrategy;
import LLD_Problems.MultilevelparkingSpot.Vehicle.Vehicle;

public class ParkingLot {
     private List<Floor> floors;
     private static ParkingLot instance;
     ParkingFinderStrategy strategy;
     
     private ParkingLot() {
		floors = new ArrayList<>();
		this.strategy = new NearestFloorStrategy();
	}
     public static ParkingLot getParkingInstance() {
		 if(instance == null)
		 {
			 instance = new ParkingLot();
		 }
		 return instance;
 	}
    public Floor addFloor(Floor floor) {
    	floors.add(floor);
    	return floor;
    }

	public List<Floor> getFloors() {
		return floors;
	}

	public void setFloors(List<Floor> floors) {
		this.floors = floors;
	}
	public ParkingFinderStrategy getStrategy() {
		return strategy;
	}

	public void setStrategy(ParkingFinderStrategy strategy) {
		this.strategy = strategy;
	}
    
	public ParkingSpot bookParkingSpot(Vehicle vehicle) {
		ParkingSpot spot = strategy.findParkingSpot(instance, vehicle);
		Floor floor = spot.getFloor();
		floor.bookPS(spot, vehicle);
		return spot;
	}

}
