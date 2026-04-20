package facade_pattern;

class Product {
	String productId;

	public Product(String productId) {
		super();
		this.productId = productId;
	}
    
}
class ProductInventory {
	public Product getProduct(String productId) {
		return new Product(productId);
	}
}
class Payment {
    public void makePayment() {
    	System.out.println("Payment Success");
    }
}
class Invoice {
	public void generateInvoice() {
    	System.out.println("Invoice generated");
    }
}
class Notification {
	public void sendNotification() {
    	System.out.println("Notification Sent");
    }
}

//Facade Layer
class OrderFacade {
	public void placeOrder(String orderId) {
		ProductInventory inventory = new ProductInventory();
		inventory.getProduct(orderId); 
		Payment payment = new Payment();
		payment.makePayment();
		Invoice invoice = new Invoice();
		invoice.generateInvoice();
		Notification notification = new Notification();
		notification.sendNotification();
		
	}
}

public class Client {
   public static void main(String[] args) {
	  OrderFacade orderFacade = new OrderFacade();
	  orderFacade.placeOrder("123");
}
}
