package concert_reservation_lld.entitites;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//Concert service having too many responsibilities. Add SeatManagerService, BookingManager service.
public class Concert {

	private volatile static Concert concertInstance;
	static Map<Integer, Seat> seatList = new ConcurrentHashMap<>();
	static Map<String, Booking> bookingList = new ConcurrentHashMap<>();
//	private final ScheduledExecutorService scheduler =
//		    Executors.newSingleThreadScheduledExecutor();
	
	private Concert() {
		super();
		//startCleanUpThread();
	}
	
//	public void startCleanUpThread() {
//		scheduler.scheduleAtFixedRate(
//			    this::releaseExpiredLocks,
//			    0,
//			    5,
//			    TimeUnit.SECONDS
//			);
//	}
//	public void releaseExpiredLocks() {
//
//	    long now = System.currentTimeMillis();
//
//	    for (Seat seat : seatList.values()) {
//
//	        synchronized(seat) {
//
//	            if(seat.getStatus() == SeatStatus.RESERVED &&
//	               now > seat.getLockedUpto()) {
//
//	                seat.releaseLock();
//	            }
//	        }
//	    }
//	}
	public static Concert getConcertInstance() {
		
		if(concertInstance == null) {
			synchronized (seatList) {
				if(concertInstance == null) {
					concertInstance = new Concert();
				}
			}
		}
		return concertInstance;
	}
 	
	public void addSeat(Seat seat) {
		seatList.put(seat.getSeatNo(),seat);
	}
	//O(n) time. Here, we can have a set of available seats. 
	//In constructor, start a single cleanup thread -> scheduler
	//This thread will run every 5 minutes and pickup all the reserved seats whose lock has expired.
	//Set status back to AVAILABLE.
	//O(available seats)
	public List<Seat> getAvailableSeats() {
	    
		List<Seat> availableSeats = new ArrayList<>();
		for(Seat seat : seatList.values()) {
			if(seat.isAvailable()) {
				availableSeats.add(seat);
			}
		}
		return availableSeats;		
	}
	
	public void reserveSeat(int seatNo, User user) {
		
		Seat seat = seatList.get(seatNo);
		if(seat == null) {
			throw new IllegalArgumentException("Seat doesnt exist");
		}
		if(!seat.reserveSeat(user)) {
			throw new RuntimeException("Seat taken");
		}
		System.out.println("Seat " + seatNo + " reserved for user " + user.getUserId());
		
	}
	
   public String confirmSeat(int seatNo, User user) {
		
		Seat seat = seatList.get(seatNo);
		if(seat == null) {
			throw new IllegalArgumentException("Seat doesnt exist");
		}
		if(!seat.confirmBooking(user)) {
			throw new RuntimeException("Seat taken");
		}
		System.out.println("Seat " + seatNo + " booked successfully for user " + user.getUserId());
		return createBooking(seat, user);
		
	}
   public String createBooking(Seat seat, User user) {
	   Booking booking = new Booking(user, seat);
	   String bookingId = booking.getBookingId();
	   bookingList.put(bookingId, booking);
	   return bookingId;
   }
    
	
	
	
	
}
