package ShippingModel.java;

public class RegionBasedDeliveryDecorator extends ShippingDecorator{

	ShippingRegion region;
	public RegionBasedDeliveryDecorator(Shipping baseShipping, ShippingRegion region) {
		super(baseShipping);
		this.region = region;
	}
	@Override
	public double calculateCost() {
		return baseShipping.calculateCost() * region.getSurge();
	}

	 @Override
	 public String getId() {
		return baseShipping.getId();
	 }
	
	
}
