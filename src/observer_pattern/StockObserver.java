package observer_pattern;

public interface StockObserver {
   void update();
}

class EmailNotification implements StockObserver {
 
	String emailAddress ;
	StockObservable obs;
	public EmailNotification(String emailAddress, StockObservable obs) {
		this.emailAddress = emailAddress;
		this.obs = obs;
	}
	
	@Override
	public void update() {
		sendEmail();
		
	}
	public void sendEmail() {
		System.out.println("Sending email to : " + emailAddress);
		System.out.println("Body : Iphone 17 pro back in stock. Hurry up, only " + obs.getStock() + " remaining.");
	}
	
}

class SMSNotification implements StockObserver {
	 
	String mobileNumber ;
	StockObservable obs;
	public SMSNotification(String mobileNumber, StockObservable obs) {
		this.mobileNumber = mobileNumber;
		this.obs = obs;
	}
	
	@Override
	public void update() {
		sendSms();
		
	}
	public void sendSms() {
		System.out.println("Sending sms to : " + mobileNumber);
		System.out.println("Body : Iphone 17 pro back in stock. Hurry up, only " + obs.getStock() + " remaining.");
	}
	
}
