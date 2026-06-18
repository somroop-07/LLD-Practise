package ShippingModel.java;

public class DeliveryTypeDecorator extends ShippingDecorator{
	
	DeliveryType type;

	public DeliveryTypeDecorator(Shipping baseShipping, DeliveryType type) {
		super(baseShipping);
		this.type = type;
	}

	@Override
	public double calculateCost() {
		return baseShipping.calculateCost() * type.getSurge();
	}
	 @Override
	 public String getId() {
		return baseShipping.getId();
	 }
	

	
}
