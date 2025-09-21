package lld_elevatorsystem.elevatoralgorithm;



public class ElevatorCarPrimary implements ElevatorCar {
     private int currentFloor;
     private Direction direction;
     private ElevatorState state;
     
 	public ElevatorCarPrimary(int currentFloor, Direction direction, ElevatorState state) {
		super();
		this.currentFloor = currentFloor;
		this.direction = direction;
		this.state = state;
	}
 	
	public int getCurrentFloor() {
		return currentFloor;
	}

	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public ElevatorState getState() {
		return state;
	}

	public void setState(ElevatorState state) {
		this.state = state;
	}

	@Override
	public void move(int floor, Direction dir) {
		this.currentFloor = floor;
		this.direction = dir;
		System.out.println("Elevator is at " + floor + " and going " + dir);
		
	}


     
    
	
}
