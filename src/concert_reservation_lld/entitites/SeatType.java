package concert_reservation_lld.entitites;

public enum SeatType {
    SILVER(1000), GOLD(3000), PLATINUM(5000);
	
	private double price;
    
    private SeatType(double price) {
    	this.price = price;
    }
    
    public double getPrice() {
    	return price;
    }
}
