package NofityStockLLD.Observable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import NofityStockLLD.enitities.Product;
import NofityStockLLD.enitities.User;
import NofityStockLLD.Observer.Observer;

public class ProductObservable implements Observable{
    
	Map<String, List<User>> subscribedUsers;
	Set<Observer> observerList;
	
	public ProductObservable() {
		// TODO Auto-generated constructor stub
		subscribedUsers = new HashMap<>();
		observerList = new HashSet<>();
	}
	
	public synchronized void subscribeUsers(User user, Product product) {
		String productId = product.getProductId();
		if(!subscribedUsers.containsKey(productId)) {
			subscribedUsers.put(productId, new ArrayList<>());
		}
		
		subscribedUsers.get(productId).add(user);
	}
	
	public synchronized void updateStock(int stock, Product product) {
		int currStock = product.getStock();
		String productId = product.getProductId();
		if(currStock == 0 && stock > 0) {
			product.setStock(stock);
			notifyObservers(product);
		}
		else {
			product.setStock(stock);
		}
	}

	@Override
	public void addObserver(Observer observer) {
		observerList.add(observer);
		
	}

	@Override
	public void notifyObservers(Product product) {
		for(Observer o : observerList) {
			o.update(subscribedUsers.getOrDefault(product.getProductId(), Collections.emptyList()), product);
		}
		subscribedUsers.remove(product.getProductId());
		
	}

	@Override
	public void removeObserver(Observer observer) {
		observerList.remove(observer);
		
	}
	
	
}
