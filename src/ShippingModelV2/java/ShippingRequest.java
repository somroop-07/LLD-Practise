package ShippingModelV2.java;

import ShippingModel.java.DeliveryType;
import ShippingModel.java.ShippingPriority;
import ShippingModel.java.ShippingRegion;

public class ShippingRequest {
    
	double weight;
	double distance;
	DeliveryType deliveryType;
	ShippingPriority shippingPriority;
	ShippingRegion region;
	
	public ShippingRequest(double weight, double distance, DeliveryType deliveryType, ShippingPriority shippingPriority,
			ShippingRegion region) {
		super();
		this.weight = weight;
		this.distance = distance;
		this.deliveryType = deliveryType;
		this.shippingPriority = shippingPriority;
		this.region = region;
	}
	public double getWeight() {
		return weight;
	}
	public double getDistance() {
		return distance;
	}
	public DeliveryType getDeliveryType() {
		return deliveryType;
	}
	public ShippingPriority getShippingPriority() {
		return shippingPriority;
	}
	public ShippingRegion getRegion() {
		return region;
	}

	
}
