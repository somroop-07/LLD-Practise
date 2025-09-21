package lld_elevatorsystem.elevatoralgorithm;

public interface ElevatorController {
	public void submitRequest(int floor, Direction direction);
	public void controlElevatorCar();
}
