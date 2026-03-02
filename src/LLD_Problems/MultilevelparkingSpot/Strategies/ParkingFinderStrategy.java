package LLD_Problems.MultilevelparkingSpot.Strategies;


import LLD_Problems.MultilevelparkingSpot.ParkingLot;
import LLD_Problems.MultilevelparkingSpot.ParkingSpot.ParkingSpot;
import LLD_Problems.MultilevelparkingSpot.Vehicle.Vehicle;

public interface ParkingFinderStrategy {
   public ParkingSpot findParkingSpot(ParkingLot parkingLot, Vehicle vehicle);
}
