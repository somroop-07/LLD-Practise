package strategy_pattern;

import java.nio.file.attribute.UserPrincipalLookupService;
import java.security.Provider.Service;

interface PaymentStrategy {
	void pay();
}

class PaymentService {
	PaymentStrategy paymentStrategy;
	void setPaymentStrategy(PaymentStrategy paymentStrategy) {
		this.paymentStrategy = paymentStrategy;
	}
	void processPayment() {
		paymentStrategy.pay();
	}
	
}
class CreditCard implements PaymentStrategy {

	@Override
	public void pay() {
		System.out.println("Paying via Credit card");
		
	}
	
}
class DebitCard implements PaymentStrategy {

	@Override
	public void pay() {
		System.out.println("Paying via Debit card");
		
	}
	
}
class UPI implements PaymentStrategy {

	String upiId;
	UPI(String upiId) {
		this.upiId = upiId;
	}
	@Override
	public void pay() {
		System.out.println("Paying via UPI " + upiId);
		
	}	
}
public class Client {
	public static void main(String[] args) {
    DebitCard card1 = new DebitCard();
    UPI upi = new UPI("somrooproy@oksbi");
    PaymentService pService = new PaymentService();
    pService.setPaymentStrategy(card1);
    pService.processPayment();
	}
}
