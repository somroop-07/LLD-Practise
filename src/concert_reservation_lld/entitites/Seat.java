package concert_reservation_lld.entitites;

public abstract class Seat {

	  int seatNo;
	  double price;
	  SeatType seatType;
	  long lockedUpto;
	  User lockedBy;
	  User bookedBy;
	  long lockTime;
	  volatile SeatStatus status;
	  
	  public Seat(int seatNo, double price, SeatType seatType) {
		super();
		this.seatNo = seatNo;
		this.price = price;
		this.seatType = seatType;
		lockedBy = null;
		lockTime = 1000 * 60 * 10;
		status = SeatStatus.AVAILABLE;
	  }
	  
	  //Not synchronized as multiple threads wont be able to get list of available seats
	  //Latency will be high
	  //Cant call releaseLockIfRequired here since can cause race conditions with reservSeat/confirmBooking
	  //Hence modifying nothing here and just check available seats and reserved seats with expired locks 
	  public boolean isAvailable() {
		 if(status.equals(SeatStatus.BOOKED)) {
			 return false;
		 }
		 if(status.equals(SeatStatus.RESERVED) && System.currentTimeMillis() <= lockedUpto) {
			 return false;
		 }
		 return true;
	  }
	  
	  public synchronized boolean reserveSeat(User user) {
		  if(!isAvailable()) {
			  return false;
		  }
		  lockedBy = user;
		  status = SeatStatus.RESERVED;
		  lockedUpto = System.currentTimeMillis() + lockTime;
		  return true;
		  
	  }
	  
	  public synchronized boolean confirmBooking(User user) {
		  releaseLockIfRequired();

		  if(!status.equals(SeatStatus.RESERVED))  {
			  return false;
		  }
		  if(!lockedBy.equals(user)) {
			  return false;
		  }
		  lockedUpto = 0;
		  lockedBy = null;
		  bookedBy = user;
		  status = SeatStatus.BOOKED;
		  return true;
		  
	  }
	  public void releaseLockIfRequired() {
		  
		  if(status.equals(SeatStatus.RESERVED) && System.currentTimeMillis() > lockedUpto) {
		  lockedBy = null;
		  status = SeatStatus.AVAILABLE;
		  }
	  }

	  @Override
	  public String toString() {
		return "Seat [seatNo=" + seatNo + "]";
	  }

	  public int getSeatNo() {
		  return seatNo;
	  }
	  
	  
	  
	   
}
