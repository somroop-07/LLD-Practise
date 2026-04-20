package LLD_Problems.AirportScheduler;

public class Runway {

    private boolean isBusy;
    private Flight currentFlight;
    private long busyUntil;

    public boolean isAvailable(long currentTime) {
        if (isBusy && currentTime >= busyUntil) {
            isBusy = false;
            currentFlight = null;
        }
        return !isBusy;
    }

    public void assignFlight(Flight flight, long currentTime) {
        this.currentFlight = flight;
        this.isBusy = true;
        this.busyUntil = currentTime + flight.getDuration();
    }

    public Flight getCurrentFlight() {
        return currentFlight;
    }
}