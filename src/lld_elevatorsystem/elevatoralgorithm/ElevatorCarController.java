package lld_elevatorsystem.elevatoralgorithm;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ElevatorCarController implements ElevatorController {
      ElevatorCarPrimary elevatorCar;
      PriorityQueue<Integer> upRequests = new PriorityQueue<>() ;
      PriorityQueue<Integer> downRequests = new PriorityQueue<>(Collections.reverseOrder()) ;
      Queue<Integer> pendingJobs = new LinkedList<>();
      
      ElevatorCarController(ElevatorCarPrimary elevatorCar) {
    	  this.elevatorCar = elevatorCar;
      }
      
      public void submitRequest(int floor, Direction direction) {
    	  this.elevatorCar.setState(ElevatorState.RUNNING);
    	  switch (direction) {
    		  case UP :
    		  {
    			  if(elevatorCar.getDirection() == Direction.UP) {
    				  if(floor < elevatorCar.getCurrentFloor()) {
    					  pendingJobs.add(floor);
    				  }
    				  else {
    					  upRequests.add(floor);
    				  }
    			  }
    			  else {
    				  upRequests.add(floor);
    			  }
    			  break;
    		  }
    		  case DOWN :
    		  {
    			  if(elevatorCar.getDirection() == Direction.DOWN) {
    				  if(floor > elevatorCar.getCurrentFloor()) {
    					  pendingJobs.add(floor);
    				  }
    				  else {
    					  downRequests.add(floor);
    				  }
    			  }
    			  else {
    				  downRequests.add(floor);
    			  }
    			  break;
    		  }
    		
		     default:
			  break;
    	     }
      }
         
      public void controlElevatorCar() {
    	  while(!upRequests.isEmpty() || !downRequests.isEmpty() || !pendingJobs.isEmpty()) {
    		  
    	  if(elevatorCar.getDirection() == Direction.UP) {
    		  while(!upRequests.isEmpty()) {
    			  this.elevatorCar.move(upRequests.poll(), Direction.UP);
        	  }
    		  elevatorCar.setDirection(Direction.DOWN);
    		  while(!pendingJobs.isEmpty()) {
    			  downRequests.add(pendingJobs.poll());
    		  }
    	  }
    	  else {
    		  while(!downRequests.isEmpty()) {
    			  this.elevatorCar.move(downRequests.poll(), Direction.DOWN);
        	  }
    		  elevatorCar.setDirection(Direction.UP);
    		  while(!pendingJobs.isEmpty()) {
    			  upRequests.add(pendingJobs.poll());
    		  }
    	  }

    	  }
    	  
    	  this.elevatorCar.setState(ElevatorState.IDLE);
    	  
    	
      }
      
}
