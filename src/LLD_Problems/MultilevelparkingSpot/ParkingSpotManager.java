package LLD_Problems.MultilevelparkingSpot;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import LLD_Problems.MultilevelparkingSpot.ParkingSpot.ParkingSpot;

import LLD_Problems.MultilevelparkingSpot.Vehicle.Vehicle;
import LLD_Problems.MultilevelparkingSpot.Vehicle.VehicleType;

public class ParkingSpotManager {
     
	private Map<VehicleType, List<ParkingSpot>> mp;
	public ParkingSpotManager() {
		mp = new HashMap<>();
	}

	public void addParkingSpot(List<ParkingSpot> spots) {
		for(ParkingSpot spot : spots) {
			VehicleType type = spot.getParkingType();
			if(!mp.containsKey(type)) {
				mp.put(type, new ArrayList<>());
			}
			mp.get(type).add(spot);
		}
	}

	public Map<VehicleType, List<ParkingSpot>> getMp() {
		return mp;
	}

	public void setMp(Map<VehicleType, List<ParkingSpot>> mp) {
		this.mp = mp;
	}

	public void bookParkingSpot(ParkingSpot spot,Vehicle vehicle) {
		spot.bookSpot(vehicle);
	}
	
	public void clearParkingSpot(ParkingSpot spot) {
		spot.freeSpot();
	}
	
}
