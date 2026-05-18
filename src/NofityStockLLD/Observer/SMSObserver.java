package NofityStockLLD.Observer;

import java.util.List;

import NofityStockLLD.enitities.Product;
import NofityStockLLD.enitities.User;

public class SMSObserver implements Observer{

	@Override
	public void update(List<User> userList, Product product) {
		
		for(User user : userList) {
			System.out.println("Sending sms to : " + user.getMob());
			System.out.printf("Body : %s back in stock. Only %s remaining.\n" , product.getProductName(), product.getStock());
		}
		 
	}

}
