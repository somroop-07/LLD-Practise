package LLD_Problems.AirportScheduler;

class Flight {
    private String flightId;
    private FlightType type;
    private long scheduledTime;
    private long duration;
    private boolean emergency;

    public Flight(String flightId, FlightType type,
                  long scheduledTime, long duration,
                  boolean emergency) {
        this.flightId = flightId;
        this.type = type;
        this.scheduledTime = scheduledTime;
        this.duration = duration;
        this.emergency = emergency;
    }

    public String getFlightId() { return flightId; }
    public FlightType getType() { return type; }
    public long getScheduledTime() { return scheduledTime; }
    public long getDuration() { return duration; }
    public boolean isEmergency() { return emergency; }

    @Override
    public String toString() {
        return "Flight{" +
                "id='" + flightId + '\'' +
                ", type=" + type +
                ", emergency=" + emergency +
                '}';
    }
}