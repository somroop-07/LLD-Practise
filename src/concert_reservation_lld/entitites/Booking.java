package concert_reservation_lld.entitites;

import java.util.UUID;

public class Booking {

	String bookingId;
	User user;
	Seat seat;
	public Booking(User user, Seat seat) {
		super();
		bookingId = UUID.randomUUID().toString();
		this.user = user;
		this.seat = seat;
	}
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	
	
	
	
}
