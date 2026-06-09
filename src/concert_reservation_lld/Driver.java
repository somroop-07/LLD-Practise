package concert_reservation_lld;

import java.util.Scanner;

import concert_reservation_lld.entitites.Concert;
import concert_reservation_lld.entitites.GoldSeat;
import concert_reservation_lld.entitites.PlatinumSeat;
import concert_reservation_lld.entitites.SilverSeat;
import concert_reservation_lld.entitites.User;

//Design BookMyShow for a Himesh Reshammiya concert. 
//Users see available seats for a show and book the ones they want. 
//A booked seat can't be booked again. 
//Now ten thousand fans hit the same show the instant it goes on sale.
//Two of them tap Book on seat F12 at the same millisecond. 
//Guarantee that seat goes to exactly one person. 
public class Driver {

	public static void main(String[] args) {
		
		 User user1 = new User("u1", "Akash");
		 User user2 = new User("u1", "Akash");
		 
		 Concert concert = Concert.getConcertInstance();
		 
		 concert.addSeat(new SilverSeat(1));
		 concert.addSeat(new SilverSeat(2));
		 concert.addSeat(new SilverSeat(3));
		 concert.addSeat(new SilverSeat(4));
		 concert.addSeat(new GoldSeat(5));
		 concert.addSeat(new GoldSeat(6));
		 concert.addSeat(new GoldSeat(7));
		 concert.addSeat(new PlatinumSeat(8));
		 concert.addSeat(new PlatinumSeat(9));
		 concert.addSeat(new PlatinumSeat(10));
		 
		 int tries = 5;
		 while(tries -- > 0) {
		 concert.getAvailableSeats().forEach(System.out::println);
		 System.out.println("Select seat");
		 Scanner sc = new Scanner(System.in);
		 int seat = sc.nextInt();
		 concert.reserveSeat(seat, user1);
		 //Mimics Payment
		 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 String bookingId = concert.confirmSeat(seat, user1);
		 System.out.println("Your booking reference id: " + bookingId);
		 
		 }

	}
}
