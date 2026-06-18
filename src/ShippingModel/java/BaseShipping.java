package ShippingModel.java;

import java.util.UUID;

public class BaseShipping implements Shipping{
	
	private String id;
	private double standardPrice;
	private double weight;
	private double distance;
    
	public BaseShipping(double weight, double distance, double standardPrice) {
		super();
		this.id = UUID.randomUUID().toString();
		this.weight = weight;
		this.distance = distance;
		this.standardPrice = standardPrice;
	}
    
	public double calculateCost() {
		return standardPrice * weight * distance;
	}

	public String getId() {
		return id;
	}

	public double getStandardPrice() {
		return standardPrice;
	}

	public double getWeight() {
		return weight;
	}

	public double getDistance() {
		return distance;
	}
    
	
	
}
