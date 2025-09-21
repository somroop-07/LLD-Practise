package factory_pattern;

public class Client {
     public static void main(String[] args) {
    	 Vehicle vehicle = VehicleFactory.createVehicle("Bike");
    	 vehicle.book();
    	 	
     }
}

interface Vehicle{
	void book();
}

class Car implements Vehicle{

	@Override
	public void book() {
		System.out.println("Booking Cab");
		
	}
}
class Bike implements Vehicle{

		@Override
		public void book() {
			System.out.println("Booking Bike");
			
		}
}
class VehicleFactory {
	public static Vehicle createVehicle(String type) {
		switch(type.toLowerCase()) {
		case "car" : {
			return new Car();
		}
		case "bike" : {
			return new Bike();
		}
		default :
			throw new IllegalArgumentException("Unsupported Transport Type");
		}
	}
}