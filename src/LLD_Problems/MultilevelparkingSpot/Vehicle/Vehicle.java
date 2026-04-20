package LLD_Problems.MultilevelparkingSpot.Vehicle;

public abstract class Vehicle {
     String regNo;
     VehicleType vehicleType;
	public Vehicle(String regNo, VehicleType vehicleType) {
		super();
		this.regNo = regNo;
		this.vehicleType = vehicleType;
	}
	public String getRegNo() {
		return regNo;
	}
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	public VehicleType getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}
     
     
}
