package LLD_Problems.AirportScheduler;

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
        if (runway.isAvailable(currentTime) && !queue.isEmpty()) {
            Flight next = queue.poll();
            runway.assignFlight(next, currentTime);
            System.out.println("Assigned flight: " + next.getFlightId());
        }
    }

    public Flight peekNext() {
        return queue.peek();
    }

    public void printQueue() {
        System.out.println("Current Queue: " + queue);
    }

}