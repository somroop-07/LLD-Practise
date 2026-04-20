package LLD_Problems.MultilevelparkingSpot;


import java.util.List;


import LLD_Problems.MultilevelparkingSpot.ParkingSpot.ParkingSpot;
import LLD_Problems.MultilevelparkingSpot.Vehicle.Vehicle;

public class Floor {
    private int floorNumber;
    private ParkingSpotManager manager;
    
	public Floor(int floorNumber) {
		super();
		this.floorNumber = floorNumber;
		this.manager = new ParkingSpotManager();
	}
    
	public void addParkingSpot(List<ParkingSpot> spots) {
		this.manager.addParkingSpot(spots);
	}
	public int getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}

    public ParkingSpotManager getManager() {
		return manager;
	}

	public void setManager(ParkingSpotManager manager) {
		this.manager = manager;
	}

	public void bookPS(ParkingSpot spot,Vehicle vehicle) {
    	this.manager.bookParkingSpot(spot, vehicle);
    }
}
