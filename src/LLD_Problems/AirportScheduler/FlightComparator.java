package LLD_Problems.AirportScheduler;

import java.util.Comparator;

/**Priority Rules:
1) Emergency landing
2) Normal landing
3)Takeoff
4)If same type → earlier scheduled time first
**/

public class FlightComparator implements Comparator<Flight> {

    @Override
    public int compare(Flight f1, Flight f2) {

        // Emergency first
        if (f1.isEmergency() && !f2.isEmergency()) return -1;
        if (!f1.isEmergency() && f2.isEmergency()) return 1;

        // Landing before takeoff
        if (f1.getType() != f2.getType()) {
            return f1.getType() == FlightType.LANDING ? -1 : 1;
        }

        // Earlier scheduled time first
        return Long.compare(f1.getScheduledTime(), f2.getScheduledTime());
    }
}