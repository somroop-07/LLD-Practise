package lld_elevatorsystem.elevatoralgorithm;

public class Client {
   public static void main(String[] args) {
	   ElevatorController controller = new ElevatorCarController(new ElevatorCarPrimary(0, Direction.UP, ElevatorState.IDLE));
	   controller.submitRequest(1, Direction.UP);
	   controller.submitRequest(7, Direction.DOWN);
	   controller.submitRequest(9, Direction.UP);
	   controller.controlElevatorCar();
   }
}

