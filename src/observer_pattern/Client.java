package observer_pattern;

public class Client {
	
	public static void main(String[] args) {
	StockObservable phoneStock = new PhoneStock();
	StockObserver observer1 = new EmailNotification("sr45@iitbbs.ac.in", phoneStock);
	StockObserver observer2 = new SMSNotification("9869585843", phoneStock);
	phoneStock.add(observer1);
	phoneStock.add(observer2);
	phoneStock.setStock(10);
	
	}
}
