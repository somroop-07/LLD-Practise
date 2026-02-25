package LLD_Problems.AirportScheduler;

//Design an Airport Scheduler (single runway).
//Schedule takeoff and landing
//Only one runway → only one operation at a time
//This is a priority scheduling problem.

public class Driver {

    public static void main(String[] args) throws InterruptedException {

        AirportScheduler scheduler = new AirportScheduler();

        long now = System.currentTimeMillis();

        // Schedule flights
        scheduler.scheduleFlight(
                new Flight("AI101", FlightType.TAKEOFF, now, 3000, false));

        scheduler.scheduleFlight(
                new Flight("AI202", FlightType.LANDING, now + 1000, 4000, false));

        scheduler.scheduleFlight(
                new Flight("AI303", FlightType.LANDING, now + 2000, 2000, true)); // emergency

        scheduler.printQueue();

        // Simulate time passing
        for (int i = 0; i < 5; i++) {
            System.out.println("\n---- Time Tick ----");
            scheduler.processNext(System.currentTimeMillis());
            Thread.sleep(3000);
        }
    }
}