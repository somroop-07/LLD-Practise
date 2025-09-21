package abstract_factory_pattern;

public class Client {
   public static void main(String[] args) {
	  VehicleFactory factory1 = new PetrolVehicleFactory();
	   Bike bike = factory1.createBike();
	   bike.book(); 
	   VehicleFactory factory2 = new ElectricVehicleFactory();
	   Car car = factory2.createCar();
	   car.book();
   }
}

interface Car{
	 void book();
}
interface Bike{
	void book();
}

class ElectricCar implements Car {

	@Override
	public void book() {
		System.out.println("Assembling ElectricCar");
		
	}
	
}
class ElectricBike implements Bike {

	@Override
	public void book() {
		System.out.println("Assembling ElectricCBike");
		
	}
	
}
class PetrolCar implements Car {

	@Override
	public void book() {
		System.out.println("Assembling PetrolCar");
		
	}
	
}
class PetrolBike implements Bike {

	@Override
	public void book() {
		System.out.println("Assembling PetrolBike");
		
	}
	
}
interface VehicleFactory{
	Car createCar();
	Bike createBike();
}

class ElectricVehicleFactory implements VehicleFactory{

	@Override
	public Car createCar() {
		return new ElectricCar();
		
	}

	@Override
	public Bike createBike() {
		return new ElectricBike();
		
	}
	
}
class PetrolVehicleFactory implements VehicleFactory{

	@Override
	public Car createCar() {
		return new  PetrolCar();
		
	}

	@Override
	public Bike createBike() {
		return new  PetrolBike();
		
	}
}