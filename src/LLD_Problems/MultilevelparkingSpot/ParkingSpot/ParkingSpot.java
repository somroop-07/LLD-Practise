package LLD_Problems.MultilevelparkingSpot.ParkingSpot;

import LLD_Problems.MultilevelparkingSpot.Floor;
import LLD_Problems.MultilevelparkingSpot.Vehicle.Vehicle;
import LLD_Problems.MultilevelparkingSpot.Vehicle.VehicleType;

public abstract class ParkingSpot {
     private static int id_global = 1;
     private int id;
     private double price;
     private boolean isEmpty;
     private Vehicle vehicle;
     private VehicleType parkingType;
     private Floor floor;
     
     
     public ParkingSpot(double price, VehicleType parkingType, Floor floor) {
    	 this.id = id_global++;
    	 this.parkingType = parkingType;
    	 this.price = price;
    	 this.isEmpty = true;
    	 this.floor = floor;
    	
     }
    public Floor getFloor() {
		return floor;
	}
	public void setFloor(Floor floor) {
		this.floor = floor;
	}
	public int getId() {
    	return this.id;
    }
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public VehicleType getParkingType() {
		return parkingType;
	}
	public void setParkingType(VehicleType parkingType) {
		this.parkingType = parkingType;
	}
	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}
	public boolean isEmpty() {
		return this.isEmpty;
	}
	public void bookSpot(Vehicle vehicle) {
		this.isEmpty = false;
		this.vehicle = vehicle;
	}
	public void freeSpot() {
		this.isEmpty = true;
		this.vehicle = null;
	}
	public boolean canAccomodate(Vehicle vehicle) {
		return vehicle.getVehicleType() == this.parkingType;
	}
     
}
