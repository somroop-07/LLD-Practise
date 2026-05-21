package LLD_Problems.AirportScheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class AirportScheduler {

    private PriorityQueue<Flight> queue;
    private Runway runway;

    public AirportScheduler() {
        this.queue = new PriorityQueue<>(new FlightComparator());
        this.runway = new Runway();
    }

    public synchronized void scheduleFlight(Flight flight) {
        queue.offer(flight);
    }

    public synchronized void processNext(long currentTime) {
    	List<Flight> notReadyFlights = new ArrayList<>();
    	Flight selectedFlight = null;
    	
    	if(!runway.isAvailable(currentTime)) {
    		return;
    	}
        while (!queue.isEmpty()) {
            Flight next = queue.poll();
            if(next.getScheduledTime() > currentTime) {
            	notReadyFlights.add(next);
            }
            else {
            	selectedFlight = next;
            	break;
            }
        }
        
        for(Flight f: notReadyFlights) {
        	queue.offer(f);
        }
        
            if(selectedFlight != null) {
            	 runway.assignFlight(selectedFlight, currentTime);
            	 System.out.println("Assigned flight: " + selectedFlight.getFlightId());
            }
            else {
            	System.out.println("No flights ready yet");
            }
           
            
    }
    
    public Flight peekNext() {
        return queue.peek();
    }

    public void printQueue() {
        System.out.println("Current Queue: " + queue);
    }

}