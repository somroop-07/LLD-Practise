package nullobject_pattern;

interface Vehicle {
	int getFuelCapacity();
}

class Car implements Vehicle {

	@Override
	public int getFuelCapacity() {
		return 100;
		
	}
}

class VehicleNullObject implements Vehicle {

	@Override
	public int getFuelCapacity() {
		return 0;
		
	}
}

class VehicleFactory {
	static Vehicle getVhicle(String type) {
		if(type.equalsIgnoreCase("car")) {
			return new Car();
		}
		return new VehicleNullObject();
	}
}

public class Client {
   public static void main(String[] args) {
	Vehicle vehicle = VehicleFactory.getVhicle("Car");
	System.out.println("Fuel capacity : " + vehicle.getFuelCapacity());
}
}
