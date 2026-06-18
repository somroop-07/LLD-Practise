package ShippingModel.java;

import java.util.HashMap;
import java.util.Map;

public class ShippingService {

	Map<String, Shipping> shippingList = new HashMap<>();
	
	public String addShipping(Shipping shipping) {
		shippingList.put(shipping.getId(), shipping);
		return shipping.getId();
	}
	
	public double calculateShippingCost(String id) {
		if(!shippingList.containsKey(id)) {
			throw new IllegalArgumentException("Shipping doesn't exist");
		}
		return shippingList.get(id).calculateCost();
	}
}
