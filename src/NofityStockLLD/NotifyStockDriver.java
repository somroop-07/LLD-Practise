package NofityStockLLD;

import NofityStockLLD.Observable.ProductObservable;
import NofityStockLLD.Observer.SMSObserver;
import NofityStockLLD.enitities.Product;
import NofityStockLLD.enitities.User;
import NofityStockLLD.enums.ProductType;


public class NotifyStockDriver {
   
	public static void main(String[] args) {
		User user1 = new User("acv", "sdsfs@df.com", "9898558985");
		User user2 = new User("sfsv", "sfafadvdsfs@df.com", "89545454545");
		User user3 = new User("lkkfdf", "ggg@df.com", "6788494945");
		Product p1 = new Product("p01", "REDMI K20", ProductType.ELECTRONICS, 0);
		
		ProductObservable productObservable = new ProductObservable();
		SMSObserver smsobserver = new SMSObserver();
		
		productObservable.addObserver(smsobserver);
		
		productObservable.subscribeUsers(user1, p1);
		productObservable.subscribeUsers(user3, p1);
		
		productObservable.updateStock(10, p1);
	}
}
