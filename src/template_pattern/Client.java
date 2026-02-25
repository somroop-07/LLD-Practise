package template_pattern;

import java.security.PublicKey;

abstract class PaymentProcessor {
	public void processPayment() {
		validate();
		debit();
		sendReceipt();
	}
	public void validate() {
		System.out.println("Validating Payement");
	}
	//Abstract Methods
	public abstract void debit();
	public void sendReceipt() {
		System.out.println("Sending Receipt");
	}
		
}
class UpiPaymentProcessor extends PaymentProcessor {

	@Override
	public void debit() {
		System.out.println("Debit throught UPI");
		
	}
	
}
class CardPaymentProcessor extends PaymentProcessor {

	@Override
	public void debit() {
		System.out.println("Debit throught Card");
		
	}
	
}
public class Client {
   public static void main(String[] args) {
	PaymentProcessor paymentProcessor = new CardPaymentProcessor();
	paymentProcessor.processPayment();
}
}
